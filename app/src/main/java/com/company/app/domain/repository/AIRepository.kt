package com.company.app.domain.repository

import com.company.app.domain.model.TranscriptChunk
import kotlinx.coroutines.flow.Flow
import java.io.File

interface AIRepository {
    fun transcribe(audioFile: File): Flow<String>
    suspend fun summarize(text: String): String
    suspend fun queryRag(prompt: String): List<TranscriptChunk>
    suspend fun generateResponse(prompt: String): Result<String>
}
