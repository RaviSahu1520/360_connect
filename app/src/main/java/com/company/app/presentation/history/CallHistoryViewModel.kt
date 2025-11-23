package com.company.app.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.model.CallType
import com.company.app.domain.usecase.call.GetCallHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallHistoryViewModel @Inject constructor(
    private val getCallHistoryUseCase: GetCallHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CallHistoryUiState())
    val uiState: StateFlow<CallHistoryUiState> = _uiState

    init {
        loadHistory()
    }

    fun loadHistory() {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            runCatching { getCallHistoryUseCase() }
                .onSuccess { list ->
                    _uiState.value = CallHistoryUiState(
                        isLoading = false,
                        items = list.map { it.toUi() }
                    )
                }
                .onFailure { error ->
                    _uiState.value = CallHistoryUiState(isLoading = false, error = error.message)
                }
        }
    }

    private fun CallWithTranscript.toUi(): CallHistoryItemUi {
        val minutes = call.durationMillis / 60000
        val seconds = (call.durationMillis / 1000) % 60
        val durationLabel = "%dm %02ds".format(minutes, seconds)
        val summaryPreview = transcript?.summary?.takeIf { it.isNotBlank() }?.take(100)
        return CallHistoryItemUi(
            callId = call.id,
            remoteUserLabel = call.remoteUserId,
            typeLabel = call.type.label(),
            timestamp = call.timestamp.toEpochMilliseconds(),
            durationFormatted = durationLabel,
            transcriptionStatus = call.transcriptionStatus.name,
            summaryPreview = summaryPreview
        )
    }

    private fun CallType.label(): String = when (this) {
        CallType.INCOMING -> "Incoming"
        CallType.OUTGOING -> "Outgoing"
        CallType.VOIP -> "VoIP"
    }
}

data class CallHistoryUiState(
    val isLoading: Boolean = true,
    val items: List<CallHistoryItemUi> = emptyList(),
    val error: String? = null
)

data class CallHistoryItemUi(
    val callId: Long,
    val remoteUserLabel: String,
    val typeLabel: String,
    val timestamp: Long,
    val durationFormatted: String,
    val transcriptionStatus: String,
    val summaryPreview: String?
)
