package com.company.app.domain.usecase.ai

import com.company.app.core.util.DateUtils
import com.company.app.data.ai.engine.MediaPipeLLM
import com.company.app.data.ai.engine.TFLiteEmbedder
import com.company.app.data.local.vector.VectorStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RagQueryUseCase @Inject constructor(
    private val embedder: TFLiteEmbedder,
    private val vectorStore: VectorStore,
    private val llm: MediaPipeLLM
) {
    suspend operator fun invoke(query: String): Result<String> = withContext(Dispatchers.Default) {
        runCatching {
            val queryVector = embedder.embed(query)
            val chunks = vectorStore.search(queryVector, limit = 5)
            if (chunks.isEmpty()) return@runCatching "No transcript context available yet."
            val context = chunks.joinToString("\n") {
                "[${DateUtils.formatDateTime(it.timestamp.toEpochMilliseconds())}]: ${it.textChunk}"
            }
            val prompt = """
                You are a helpful assistant. Answer the question based ONLY on the transcript context below.
                Context:
                $context

                Question: $query
            """.trimIndent()
            llm.generateResponse(prompt)
        }
    }
}
