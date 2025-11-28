package com.company.app.presentation.ai

sealed class AiState {
    object Idle : AiState()
    object Loading : AiState()
    data class Success(val answer: String) : AiState()
    data class Error(val message: String) : AiState()
}
