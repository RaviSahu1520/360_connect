package com.company.app.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.company.app.data.ai.engine.TFLiteEmbedder
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.vector.VectorStore
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class EmbeddingWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val embedder: TFLiteEmbedder,
    private val vectorStore: VectorStore,
    private val transcriptDao: TranscriptDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val callId = inputData.getLong(TranscriptionWorker.KEY_CALL_ID, -1L)
        if (callId <= 0) return Result.failure()
        val transcriptId = inputData.getLong(TranscriptionWorker.KEY_TRANSCRIPT_ID, -1L)
        val transcript = if (transcriptId > 0) transcriptDao.getById(transcriptId) else transcriptDao.findByCallId(callId)
        transcript ?: return Result.failure()

        return runCatching {
            val chunks = chunkTranscript(transcript.fullText)
            for (chunk in chunks) {
                val embedding = embedder.embed(chunk)
                vectorStore.insertChunk(
                    transcriptId = transcript.id,
                    callId = transcript.callId,
                    text = chunk,
                    embedding = embedding,
                    timestamp = transcript.timestamp
                )
            }
            Log.d(TAG, "Embedded ${chunks.size} chunks for transcript=${transcript.id}")
            Result.success()
        }.getOrElse {
            Log.e(TAG, "Embedding failed", it)
            if (runAttemptCount < MAX_RETRIES) Result.retry() else Result.failure()
        }
    }

    private fun chunkTranscript(text: String): List<String> {
        if (text.isBlank()) return emptyList()
        val words = text.split(Regex("\\s+"))
        val chunks = mutableListOf<String>()
        var buffer = mutableListOf<String>()
        for (word in words) {
            buffer.add(word)
            if (buffer.size >= 240) { // 200-300 token window approximation
                chunks.add(buffer.joinToString(" "))
                buffer = mutableListOf()
            }
        }
        if (buffer.isNotEmpty()) {
            chunks.add(buffer.joinToString(" "))
        }
        return chunks
    }

    companion object {
        private const val TAG = "EmbeddingWorker"
        private const val MAX_RETRIES = 2
    }
}
