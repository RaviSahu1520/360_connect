package com.company.app.data.repository

import com.company.app.core.common.DispatcherProvider
import com.company.app.core.security.EncryptionManager
import com.company.app.data.local.dao.CallDao
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.entity.CallEntity
import com.company.app.data.local.entity.TranscriptEntity
import com.company.app.data.local.model.CallWithTranscriptLocal
import com.company.app.domain.model.Call
import com.company.app.domain.model.CallInfo
import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.model.Transcript
import com.company.app.domain.model.TranscriptionStatus
import com.company.app.domain.repository.CallRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Instant
import javax.inject.Inject

class CallRepositoryImpl @Inject constructor(
    private val callDao: CallDao,
    private val transcriptDao: TranscriptDao,
    private val encryptionManager: EncryptionManager,
    private val dispatchers: DispatcherProvider
) : CallRepository {

    override fun observeCalls(): Flow<List<Call>> = callDao.observeCalls().map { list ->
        list.map { it.toDomain(encryptionManager) }
    }

    override fun observeTranscript(callId: Long): Flow<Transcript?> =
        transcriptDao.observeTranscript(callId).map { entity -> entity?.toDomain() }

    override suspend fun startCall(remoteUserId: String): Long = withContext(dispatchers.io) {
        val callId = callDao.upsert(
            CallEntity(
                remoteUserId = remoteUserId,
                source = "VOIP",
                type = com.company.app.domain.model.CallType.VOIP,
                timestamp = System.currentTimeMillis(),
                duration = 0,
                audioFilePath = "",
                transcriptionStatus = TranscriptionStatus.PENDING
            )
        )
        transcriptDao.upsert(
            TranscriptEntity(
                callId = callId,
                fullText = "",
                summary = "",
                speakerMap = "{}",
                timestamp = System.currentTimeMillis()
            )
        )
        callId
    }

    override suspend fun createCallRecord(callInfo: CallInfo): Long = withContext(dispatchers.io) {
        val callId = callDao.insert(
            CallEntity(
                remoteUserId = callInfo.displayName ?: callInfo.remoteUserId,
                source = callInfo.source,
                type = callInfo.type,
                timestamp = callInfo.startedAt.toEpochMilliseconds(),
                duration = 0L,
                audioFilePath = "",
                transcriptionStatus = TranscriptionStatus.PENDING
            )
        )
        transcriptDao.upsert(
            TranscriptEntity(
                callId = callId,
                fullText = "",
                summary = "",
                speakerMap = "{}",
                timestamp = callInfo.startedAt.toEpochMilliseconds()
            )
        )
        callId
    }

    override suspend fun markCallCompleted(callId: Long, filePath: String, durationMillis: Long) {
        withContext(dispatchers.io) {
            val encryptedPath = encryptionManager.encrypt(filePath)
            callDao.updateRecordingData(
                id = callId,
                status = TranscriptionStatus.PENDING.name,
                filePath = encryptedPath,
                duration = durationMillis
            )
        }
    }

    override suspend fun getAllCallsWithTranscripts(): List<CallWithTranscript> = withContext(dispatchers.io) {
        callDao.getAllCallsWithTranscripts().map { it.toDomain(encryptionManager) }
    }

    override suspend fun getCallWithTranscript(callId: Long): CallWithTranscript? = withContext(dispatchers.io) {
        callDao.getCallWithTranscriptById(callId)?.toDomain(encryptionManager)
    }
}

private fun CallEntity.toDomain(
    encryptionManager: EncryptionManager
) = Call(
    id = id,
    remoteUserId = remoteUserId,
    source = source,
    type = type,
    timestamp = Instant.fromEpochMilliseconds(timestamp),
    durationMillis = duration,
    audioFilePath = runCatching { encryptionManager.decrypt(audioFilePath) }.getOrDefault(audioFilePath),
    transcriptionStatus = transcriptionStatus
)

private fun TranscriptEntity.toDomain() = Transcript(
    id = id,
    callId = callId,
    fullText = fullText,
    summary = summary,
    speakerMap = emptyMap(),
    timestamp = Instant.fromEpochMilliseconds(timestamp)
)

private fun CallWithTranscriptLocal.toDomain(encryptionManager: EncryptionManager): CallWithTranscript =
    CallWithTranscript(
        call = call.toDomain(encryptionManager),
        transcript = transcript?.toDomain()
    )
