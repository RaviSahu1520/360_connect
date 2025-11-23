package com.company.app.domain.usecase.call

import com.company.app.domain.model.Transcript
import com.company.app.domain.repository.CallRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveTranscriptUseCase @Inject constructor(
    private val repository: CallRepository
) {
    operator fun invoke(callId: Long): Flow<Transcript?> = repository.observeTranscript(callId)
}
