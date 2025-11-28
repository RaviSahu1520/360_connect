package com.company.app.domain.usecase.ai

import com.company.app.core.util.DateUtils
import com.company.app.data.ai.engine.TFLiteEmbedder
import com.company.app.data.local.vector.VectorStore
import com.company.app.data.remote.llm.LLMEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CallScopedRAGQueryUseCase @Inject constructor(
    private val embedder: TFLiteEmbedder,
    private val vectorStore: VectorStore,
    private val llmEngine: LLMEngine
) {
    suspend operator fun invoke(callId: Long, query: String): Result<String> = withContext(Dispatchers.Default) {
        try {
            val queryVector = embedder.embed(query)
            val chunks = vectorStore.findNearestForCall(callId, queryVector, limit = 5)
            if (chunks.isEmpty()) return@withContext Result.success("No transcript context available yet.")
            val context = chunks.joinToString("\n") {
                "[${DateUtils.formatDateTime(it.timestamp.toEpochMilliseconds())}]: ${it.textChunk}"
            }
            val prompt = """
                You are a helpful assistant. Answer the question based ONLY on the call transcript context below.
                Context:
                $context

                Question: $query
            """.trimIndent()
            val answer = llmEngine.generateResponse(prompt)
            Result.success(answer)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
