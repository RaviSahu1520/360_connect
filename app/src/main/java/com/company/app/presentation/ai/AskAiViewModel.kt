package com.company.app.presentation.ai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.usecase.ai.RagQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AskAiViewModel @Inject constructor(
    private val ragQueryUseCase: RagQueryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AskAiUiState())
    val uiState: StateFlow<AskAiUiState> = _uiState

    fun onQueryChange(new: String) {
        _uiState.value = _uiState.value.copy(query = new)
    }

    fun submitQuery() {
        val currentQuery = _uiState.value.query
        if (currentQuery.isBlank()) return
        _uiState.value = _uiState.value.copy(aiState = AiState.Loading)
        viewModelScope.launch {
            val result = ragQueryUseCase(currentQuery)
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
}

data class AskAiUiState(
    val query: String = "",
    val aiState: AiState = AiState.Idle
) {
    val isLoading: Boolean get() = aiState is AiState.Loading
    val answer: String? get() = (aiState as? AiState.Success)?.answer
    val error: String? get() = (aiState as? AiState.Error)?.message
}
