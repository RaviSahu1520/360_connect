package com.company.app.domain.usecase.ai

import com.company.app.domain.repository.AIRepository
import javax.inject.Inject

data class ProcessRecordingRequest(
    val audioPath: String
)

class ProcessRecordingUseCase @Inject constructor(
    private val repository: AIRepository
) {
    fun execute(request: ProcessRecordingRequest) = repository.transcribe(java.io.File(request.audioPath))
}
