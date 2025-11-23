package com.company.app.domain.usecase.ai

import com.company.app.domain.repository.AIRepository
import javax.inject.Inject

class TranscribeCallUseCase @Inject constructor(
    private val repository: AIRepository
) {
    fun execute(audioPath: String) = repository.transcribe(java.io.File(audioPath))
}
