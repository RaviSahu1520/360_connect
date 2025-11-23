package com.company.app.presentation.call

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.CallInfo
import com.company.app.domain.model.CallType
import com.company.app.domain.usecase.ai.RagQueryUseCase
import com.company.app.domain.usecase.ai.TranscribeCallUseCase
import com.company.app.domain.usecase.call.StartRecordingUseCase
import com.company.app.domain.usecase.call.StopRecordingUseCase
import com.company.app.platform.call.CallConnectionState
import com.company.app.platform.call.VoipClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallViewModel @Inject constructor(
    private val voipClient: VoipClient,
    private val startRecordingUseCase: StartRecordingUseCase,
    private val stopRecordingUseCase: StopRecordingUseCase,
    private val transcribeCallUseCase: TranscribeCallUseCase,
    private val ragQueryUseCase: RagQueryUseCase
) : ViewModel() {

    private val transcription = MutableStateFlow("")
    private val ragAnswer = MutableStateFlow<String?>(null)
    private val ragError = MutableStateFlow<String?>(null)

    val uiState: StateFlow<CallUiState> = combine(
        voipClient.state,
        transcription,
        ragAnswer,
        ragError
    ) { connection, transcript, answer, error ->
        CallUiState(connection, transcript, answer, error)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, CallUiState())

    fun startCall(remoteUserId: String) {
        viewModelScope.launch {
            startRecordingUseCase(
                CallInfo(
                    remoteUserId = remoteUserId,
                    type = CallType.VOIP,
                    source = "VOIP"
                )
            )
            voipClient.startCall(remoteUserId)
        }
    }

    fun endCall() {
        viewModelScope.launch {
            stopRecordingUseCase()
            voipClient.endCall()
        }
    }

    fun toggleMute() {
        voipClient.toggleMute()
    }

    fun transcribe(audioPath: String) {
        viewModelScope.launch {
            transcribeCallUseCase.execute(audioPath).collect { transcription.emit(it) }
        }
    }

    fun queryRag(prompt: String) {
        viewModelScope.launch {
            ragError.emit(null)
            val result = ragQueryUseCase(prompt)
            if (result.isSuccess) {
                ragAnswer.emit(result.getOrNull())
            } else {
                ragError.emit(result.exceptionOrNull()?.message ?: "Query failed")
            }
        }
    }
}

data class CallUiState(
    val connection: CallConnectionState = CallConnectionState(),
    val transcriptionText: String = "",
    val aiAnswer: String? = null,
    val aiError: String? = null
)
