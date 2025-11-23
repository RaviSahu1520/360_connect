package com.company.app.domain.model

import kotlinx.datetime.Instant

enum class CallType { INCOMING, OUTGOING, VOIP }

enum class TranscriptionStatus { PENDING, COMPLETED, FAILED }

data class Call(
    val id: Long,
    val remoteUserId: String,
    val source: String,
    val type: CallType,
    val timestamp: Instant,
    val durationMillis: Long,
    val audioFilePath: String,
    val transcriptionStatus: TranscriptionStatus
)

data class CallInfo(
    val remoteUserId: String,
    val displayName: String? = null,
    val type: CallType,
    val source: String,
    val startedAt: Instant = Instant.fromEpochMilliseconds(System.currentTimeMillis())
)

data class Transcript(
    val id: Long,
    val callId: Long,
    val fullText: String,
    val summary: String,
    val speakerMap: Map<String, String>,
    val timestamp: Instant
)

data class Message(
    val id: String,
    val chatId: String,
    val senderId: String,
    val content: String,
    val timestamp: Instant,
    val isLocalUser: Boolean
)

data class TranscriptChunk(
    val callId: Long,
    val transcriptId: Long,
    val textChunk: String,
    val embedding: FloatArray,
    val timestamp: Instant
)
