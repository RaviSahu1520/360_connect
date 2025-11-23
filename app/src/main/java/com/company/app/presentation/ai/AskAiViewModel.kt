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
        _uiState.value = _uiState.value.copy(isLoading = true, error = null, answer = null)
        viewModelScope.launch {
            val result = ragQueryUseCase(currentQuery)
            _uiState.value = if (result.isSuccess) {
                _uiState.value.copy(isLoading = false, answer = result.getOrNull())
            } else {
                _uiState.value.copy(isLoading = false, error = result.exceptionOrNull()?.message)
            }
        }
    }
}

data class AskAiUiState(
    val query: String = "",
    val isLoading: Boolean = false,
    val answer: String? = null,
    val error: String? = null
)
