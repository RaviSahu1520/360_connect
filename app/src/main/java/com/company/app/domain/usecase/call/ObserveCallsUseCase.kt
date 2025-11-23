package com.company.app.domain.usecase.call

import com.company.app.domain.model.Call
import com.company.app.domain.repository.CallRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveCallsUseCase @Inject constructor(
    private val repository: CallRepository
) {
    operator fun invoke(): Flow<List<Call>> = repository.observeCalls()
}
