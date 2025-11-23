package com.company.app.domain.usecase.chat

import com.company.app.domain.repository.ChatRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(chatId: String, message: String) {
        repository.sendMessage(chatId, message)
    }
}
