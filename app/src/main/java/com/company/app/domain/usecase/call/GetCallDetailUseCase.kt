package com.company.app.domain.usecase.call

import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.repository.CallRepository
import javax.inject.Inject

class GetCallDetailUseCase @Inject constructor(
    private val callRepository: CallRepository
) {
    suspend operator fun invoke(callId: Long): CallWithTranscript? =
        callRepository.getCallWithTranscript(callId)
}
