package com.company.app.domain.repository

import com.company.app.domain.model.Call
import com.company.app.domain.model.CallInfo
import com.company.app.domain.model.CallWithTranscript
import com.company.app.domain.model.Transcript
import kotlinx.coroutines.flow.Flow

interface CallRepository {
    fun observeCalls(): Flow<List<Call>>
    fun observeTranscript(callId: Long): Flow<Transcript?>
    suspend fun startCall(remoteUserId: String): Long
    suspend fun createCallRecord(callInfo: CallInfo): Long
    suspend fun markCallCompleted(callId: Long, filePath: String, durationMillis: Long)
    suspend fun getAllCallsWithTranscripts(): List<CallWithTranscript>
    suspend fun getCallWithTranscript(callId: Long): CallWithTranscript?
}
