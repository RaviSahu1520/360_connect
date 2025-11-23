package com.company.app.domain.usecase.chat

import com.company.app.domain.model.Message
import com.company.app.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveChatMessagesUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    operator fun invoke(chatId: String): Flow<List<Message>> = repository.observeMessages(chatId)
}
