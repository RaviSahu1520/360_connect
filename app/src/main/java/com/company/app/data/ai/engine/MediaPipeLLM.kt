package com.company.app.data.ai.engine

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaPipeLLM @Inject constructor() {
    suspend fun summarize(text: String): String {
        delay(100)
        val sentences = text.split(Regex("(?<=[.!?])"))
            .filter { it.isNotBlank() }
            .take(6)
        return sentences.joinToString(" ").ifBlank { text.take(160) }
    }

    suspend fun chat(history: List<String>, query: String): String {
        delay(100)
        return "AI response based on ${history.size} messages: $query"
    }

    suspend fun generateResponse(prompt: String): String {
        delay(120)
        return "AI answer: ${prompt.take(240)}"
    }
}
