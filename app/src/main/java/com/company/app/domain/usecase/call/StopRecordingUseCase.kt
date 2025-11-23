package com.company.app.domain.usecase.call

import com.company.app.platform.recording.CallRecordingController
import javax.inject.Inject

class StopRecordingUseCase @Inject constructor(
    private val callRecordingController: CallRecordingController
) {
    suspend operator fun invoke() {
        callRecordingController.stopRecording()
    }
}
