package com.company.app.presentation.chat

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.app.domain.model.Message
import com.company.app.domain.usecase.chat.ObserveChatMessagesUseCase
import com.company.app.domain.usecase.chat.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    observeChatMessagesUseCase: ObserveChatMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    private val chatId: String = checkNotNull(savedStateHandle["chatId"]) {
        "Chat id is required"
    }

    private val inputFlow = MutableStateFlow("")

    val uiState: StateFlow<ChatUiState> = combine(
        observeChatMessagesUseCase(chatId),
        inputFlow
    ) { messages, input ->
        ChatUiState(messages = messages, input = input)
    }.stateIn(viewModelScope, SharingStarted.Lazily, ChatUiState())

    fun onMessageChanged(value: String) {
        inputFlow.value = value
    }

    fun onSendClicked() {
        val message = inputFlow.value
        if (message.isBlank()) return
        viewModelScope.launch {
            sendMessageUseCase(chatId, message)
            inputFlow.value = ""
        }
    }
}

data class ChatUiState(
    val messages: List<Message> = emptyList(),
    val input: String = ""
)
