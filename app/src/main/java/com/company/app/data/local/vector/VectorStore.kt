package com.company.app.data.local.vector

import com.company.app.domain.model.TranscriptChunk
import com.company.app.data.local.vector.TranscriptEmbedding
import kotlinx.datetime.Instant
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

interface VectorStore {
    fun insertChunk(
        transcriptId: Long,
        callId: Long,
        text: String,
        embedding: FloatArray,
        timestamp: Long = System.currentTimeMillis()
    ): TranscriptChunk

    fun search(queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk>

    suspend fun findNearestForCall(callId: Long, queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk>
}

class InMemoryVectorStore : VectorStore {
    private val items = mutableListOf<TranscriptEmbedding>()
    private val idGenerator = AtomicLong()

    override fun insertChunk(transcriptId: Long, callId: Long, text: String, embedding: FloatArray, timestamp: Long): TranscriptChunk {
        val embeddingEntry = TranscriptEmbedding(
            id = idGenerator.incrementAndGet(),
            transcriptId = transcriptId,
            callId = callId,
            textChunk = text,
            embedding = embedding,
            timestamp = timestamp
        )
        items += embeddingEntry
        return embeddingEntry.toDomainChunk()
    }

    override fun search(queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk> {
        return items.sortedByDescending { cosineSimilarity(it.embedding, queryEmbedding) }
            .take(limit)
            .map { it.toDomainChunk() }
    }

    override suspend fun findNearestForCall(callId: Long, queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk> {
        return items.filter { it.callId == callId }
            .sortedByDescending { cosineSimilarity(it.embedding, queryEmbedding) }
            .take(limit)
            .map { it.toDomainChunk() }
    }

    private fun TranscriptEmbedding.toDomainChunk(): TranscriptChunk = TranscriptChunk(
        callId = callId,
        transcriptId = transcriptId,
        textChunk = textChunk,
        embedding = embedding,
        timestamp = Instant.fromEpochMilliseconds(timestamp)
    )

    private fun cosineSimilarity(first: FloatArray, second: FloatArray): Float {
        val dot = first.zip(second) { a, b -> a * b }.sum()
        val firstNorm = sqrt(first.fold(0f) { acc, value -> acc + value * value })
        val secondNorm = sqrt(second.fold(0f) { acc, value -> acc + value * value })
        if (firstNorm == 0f || secondNorm == 0f) return 0f
        return dot / (firstNorm * secondNorm)
    }
}
