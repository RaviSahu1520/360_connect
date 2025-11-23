package com.company.app.data.local.vector

data class TranscriptEmbedding(
    val id: Long,
    val transcriptId: Long,
    val callId: Long,
    val textChunk: String,
    val embedding: FloatArray,
    val timestamp: Long
)
