package com.company.app.data.repository

import com.company.app.data.ai.engine.TFLiteEmbedder
import com.company.app.data.ai.engine.WhisperEngine
import com.company.app.data.local.vector.VectorStore
import com.company.app.data.remote.llm.LLMEngine
import com.company.app.domain.model.TranscriptChunk
import com.company.app.domain.repository.AIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AIRepositoryImpl @Inject constructor(
    private val whisperEngine: WhisperEngine,
    private val llmEngine: LLMEngine,
    private val embedder: TFLiteEmbedder,
    private val vectorStore: VectorStore
) : AIRepository {

    override fun transcribe(audioFile: java.io.File): Flow<String> = flow {
        val text = whisperEngine.transcribe(audioFile)
        if (text.isNotBlank()) {
            indexTranscript(-1L, text)
        }
        emit(text)
    }

    override suspend fun summarize(text: String): String {
        val prompt = "Summarize this text briefly and clearly:\n$text"
        return llmEngine.generateResponse(prompt)
    }

    override suspend fun queryRag(prompt: String): List<TranscriptChunk> {
        val embedding = embedder.embed(prompt)
        return vectorStore.search(embedding, limit = 5).sortedBy { it.timestamp }.map { chunk ->
            chunk.copy(textChunk = "[${formatTimestamp(chunk)}] ${chunk.textChunk}")
        }
    }

    override suspend fun generateResponse(prompt: String): Result<String> = runCatching {
        llmEngine.generateResponse(prompt)
    }

    private suspend fun indexTranscript(transcriptId: Long, fullText: String) {
        if (fullText.isBlank()) return
        fullText.chunked(240).forEach { chunk ->
            val embedding = embedder.embed(chunk)
            vectorStore.insertChunk(transcriptId, callId = -1, text = chunk, embedding = embedding)
        }
    }

    private fun formatTimestamp(chunk: TranscriptChunk): String {
        val millis = chunk.timestamp.toEpochMilliseconds()
        val formatter = java.text.SimpleDateFormat("HH:mm:ss", java.util.Locale.US)
        return formatter.format(java.util.Date(millis))
    }
}
