package com.company.app.domain.repository

import com.company.app.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun observeMessages(chatId: String): Flow<List<Message>>
    suspend fun sendMessage(chatId: String, content: String)
}
