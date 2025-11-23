package com.company.app.data.repository

import com.company.app.core.common.DispatcherProvider
import com.company.app.core.security.EncryptionManager
import com.company.app.data.local.dao.MessageDao
import com.company.app.data.local.entity.MessageEntity
import com.company.app.domain.model.Message
import com.company.app.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Instant
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val messageDao: MessageDao,
    private val encryptionManager: EncryptionManager,
    private val dispatchers: DispatcherProvider
) : ChatRepository {

    private val localUserId = "local-user"

    override fun observeMessages(chatId: String): Flow<List<Message>> {
        return messageDao.observeMessages(chatId).map { entities ->
            entities.map { it.toDomain(encryptionManager, localUserId) }
        }
    }

    override suspend fun sendMessage(chatId: String, content: String) {
        withContext(dispatchers.io) {
            val entity = MessageEntity(
                id = System.currentTimeMillis().toString(),
                chatId = chatId,
                senderId = localUserId,
                contentEncrypted = encryptionManager.encrypt(content),
                timestamp = System.currentTimeMillis()
            )
            messageDao.upsert(entity)
        }
    }
}

private fun MessageEntity.toDomain(
    encryptionManager: EncryptionManager,
    localUserId: String
): Message = Message(
    id = id,
    chatId = chatId,
    senderId = senderId,
    content = runCatching { encryptionManager.decrypt(contentEncrypted) }.getOrDefault(""),
    timestamp = Instant.fromEpochMilliseconds(timestamp),
    isLocalUser = senderId == localUserId
)
