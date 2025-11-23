package com.company.app.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.model.CallType
import com.company.app.domain.usecase.ai.CallScopedRAGQueryUseCase
import com.company.app.domain.usecase.call.GetCallDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallDetailViewModel @Inject constructor(
    private val getCallDetailUseCase: GetCallDetailUseCase,
    private val callScopedRagQueryUseCase: CallScopedRAGQueryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CallDetailUiState())
    val uiState: StateFlow<CallDetailUiState> = _uiState

    fun load(callId: Long) {
        _uiState.value = _uiState.value.copy(isLoading = true, aiError = null, aiAnswer = null)
        viewModelScope.launch {
            runCatching { getCallDetailUseCase(callId) }
                .onSuccess { detail ->
                    if (detail == null) {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            aiError = "Call not found"
                        )
                    } else {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            header = detail.toHeader(),
                            transcript = detail.transcript?.fullText,
                            summary = detail.transcript?.summary
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.value = _uiState.value.copy(isLoading = false, aiError = error.message)
                }
        }
    }

    fun askAiAboutCall(callId: Long, query: String) {
        _uiState.value = _uiState.value.copy(aiIsLoading = true, aiError = null)
        viewModelScope.launch {
            val result = callScopedRagQueryUseCase(callId, query)
            _uiState.value = if (result.isSuccess) {
                _uiState.value.copy(aiIsLoading = false, aiAnswer = result.getOrNull())
            } else {
                _uiState.value.copy(aiIsLoading = false, aiError = result.exceptionOrNull()?.message)
            }
        }
    }

    private fun CallWithTranscript.toHeader(): CallHeaderUi {
        val minutes = call.durationMillis / 60000
        val seconds = (call.durationMillis / 1000) % 60
        val durationLabel = "%dm %02ds".format(minutes, seconds)
        return CallHeaderUi(
            remoteUserLabel = call.remoteUserId,
            typeLabel = when (call.type) {
                CallType.INCOMING -> "Incoming"
                CallType.OUTGOING -> "Outgoing"
                CallType.VOIP -> "VoIP"
            },
            timestamp = call.timestamp.toEpochMilliseconds(),
            durationFormatted = durationLabel,
            transcriptionStatus = call.transcriptionStatus.name
        )
    }
}

data class CallDetailUiState(
    val isLoading: Boolean = true,
    val header: CallHeaderUi? = null,
    val transcript: String? = null,
    val summary: String? = null,
    val aiAnswer: String? = null,
    val aiIsLoading: Boolean = false,
    val aiError: String? = null
)

data class CallHeaderUi(
    val remoteUserLabel: String,
    val typeLabel: String,
    val timestamp: Long,
    val durationFormatted: String,
    val transcriptionStatus: String
)
