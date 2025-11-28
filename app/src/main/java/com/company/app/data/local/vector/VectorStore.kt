package com.company.app.data.local.vector

import com.company.app.data.local.dao.EmbeddingDao
import com.company.app.data.local.vector.TranscriptEmbeddingEntity
import com.company.app.domain.model.TranscriptChunk
import kotlinx.datetime.Instant
import javax.inject.Inject
import kotlin.math.sqrt

interface VectorStore {
    suspend fun insertChunk(
        transcriptId: Long,
        callId: Long,
        text: String,
        embedding: FloatArray,
        timestamp: Long = System.currentTimeMillis()
    ): TranscriptChunk

    suspend fun search(queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk>

    suspend fun findNearestForCall(callId: Long, queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk>
}

class RoomVectorStore @Inject constructor(
    private val embeddingDao: EmbeddingDao,
    private val converters: EmbeddingConverters
) : VectorStore {
    override suspend fun insertChunk(
        transcriptId: Long,
        callId: Long,
        text: String,
        embedding: FloatArray,
        timestamp: Long
    ): TranscriptChunk {
        val entity = TranscriptEmbeddingEntity(
            transcriptId = transcriptId,
            callId = callId,
            textChunk = text,
            embeddingJson = converters.fromFloatArray(embedding),
            timestamp = timestamp
        )
        embeddingDao.insert(entity)
        return entity.toDomainChunk(embedding)
    }

    override suspend fun search(queryEmbedding: FloatArray, limit: Int): List<TranscriptChunk> {
        val all = embeddingDao.getAll()
        return rankEmbeddings(all, queryEmbedding, limit)
    }

    override suspend fun findNearestForCall(
        callId: Long,
        queryEmbedding: FloatArray,
        limit: Int
    ): List<TranscriptChunk> {
        val callEmbeddings = embeddingDao.getByCallId(callId)
        return rankEmbeddings(callEmbeddings, queryEmbedding, limit)
    }

    private fun rankEmbeddings(
        entities: List<TranscriptEmbeddingEntity>,
        queryEmbedding: FloatArray,
        limit: Int
    ): List<TranscriptChunk> {
        return entities.map { entity ->
            val vector = converters.toFloatArray(entity.embeddingJson)
            val score = cosineSimilarity(vector, queryEmbedding)
            Triple(entity, vector, score)
        }
            .sortedByDescending { it.third }
            .take(limit)
            .map { (entity, vector) -> entity.toDomainChunk(vector) }
    }

    private fun TranscriptEmbeddingEntity.toDomainChunk(vec: FloatArray): TranscriptChunk = TranscriptChunk(
        callId = callId,
        transcriptId = transcriptId,
        textChunk = textChunk,
        embedding = vec,
        timestamp = Instant.fromEpochMilliseconds(timestamp)
    )

    private fun cosineSimilarity(first: FloatArray, second: FloatArray): Float {
        var dot = 0f
        var firstNorm = 0f
        var secondNorm = 0f
        val size = minOf(first.size, second.size)
        for (i in 0 until size) {
            val a = first[i]
            val b = second[i]
            dot += a * b
            firstNorm += a * a
            secondNorm += b * b
        }
        if (firstNorm == 0f || secondNorm == 0f) return 0f
        return dot / (sqrt(firstNorm) * sqrt(secondNorm))
    }
}
