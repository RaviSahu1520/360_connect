package com.company.app.platform.call

import com.company.app.domain.model.CallInfo
import com.company.app.domain.model.CallType
import com.company.app.platform.recording.CallRecordingController
import com.company.app.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CallSimulator @Inject constructor(
    private val callRecordingController: CallRecordingController
) {

    suspend fun simulateIncomingCall(number: String) {
        if (!BuildConfig.DEBUG) return
        callRecordingController.startRecording(
            CallInfo(
                remoteUserId = number,
                type = CallType.INCOMING,
                source = "SYSTEM_CALL"
            )
        )
    }

    suspend fun simulateCallEnd() {
        if (!BuildConfig.DEBUG) return
        callRecordingController.stopRecording()
    }
}
