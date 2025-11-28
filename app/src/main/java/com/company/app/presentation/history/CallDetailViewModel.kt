package com.company.app.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.model.CallType
import com.company.app.domain.usecase.ai.CallScopedRAGQueryUseCase
import com.company.app.domain.usecase.call.GetCallDetailUseCase
import com.company.app.presentation.ai.AiState
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
        _uiState.value = _uiState.value.copy(isLoading = true, aiState = AiState.Idle)
        viewModelScope.launch {
            runCatching { getCallDetailUseCase(callId) }
                .onSuccess { detail ->
                    if (detail == null) {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            aiState = AiState.Error("Call not found")
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
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        aiState = AiState.Error(error.message ?: "Unknown error")
                    )
                }
        }
    }

    fun askAiAboutCall(callId: Long, query: String) {
        _uiState.value = _uiState.value.copy(aiState = AiState.Loading)
        viewModelScope.launch {
            val result = callScopedRagQueryUseCase(callId, query)
            _uiState.value = result.fold(
                onSuccess = { answer ->
                    val safeAnswer = if (answer.isBlank()) "Error: Empty response" else answer
                    _uiState.value.copy(aiState = AiState.Success(safeAnswer))
                },
                onFailure = { error ->
                    _uiState.value.copy(aiState = AiState.Error(error.message ?: "Unknown error"))
                }
            )
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
    val aiState: AiState = AiState.Idle
) {
    val aiAnswer: String? get() = (aiState as? AiState.Success)?.answer
    val aiIsLoading: Boolean get() = aiState is AiState.Loading
    val aiError: String? get() = (aiState as? AiState.Error)?.message
}

data class CallHeaderUi(
    val remoteUserLabel: String,
    val typeLabel: String,
    val timestamp: Long,
    val durationFormatted: String,
    val transcriptionStatus: String
)
