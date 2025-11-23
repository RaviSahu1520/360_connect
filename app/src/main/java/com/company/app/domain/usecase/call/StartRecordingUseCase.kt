package com.company.app.domain.usecase.call

import com.company.app.domain.model.CallInfo
import com.company.app.platform.recording.CallRecordingController
import javax.inject.Inject

class StartRecordingUseCase @Inject constructor(
    private val callRecordingController: CallRecordingController
) {
    suspend operator fun invoke(callInfo: CallInfo) {
        callRecordingController.startRecording(callInfo)
    }
}
