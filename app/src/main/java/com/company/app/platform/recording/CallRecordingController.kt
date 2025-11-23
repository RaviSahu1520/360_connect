package com.company.app.platform.recording

import android.content.Context
import android.content.Intent
import android.os.Environment
import androidx.core.content.ContextCompat
import com.company.app.core.common.DispatcherProvider
import com.company.app.domain.model.CallInfo
import com.company.app.domain.repository.CallRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CallRecordingController @Inject constructor(
    @ApplicationContext private val context: Context,
    private val callRepository: CallRepository,
    private val audioCaptureManager: AudioCaptureManager,
    private val dispatchers: DispatcherProvider
) {

    private val scope = CoroutineScope(SupervisorJob() + dispatchers.io)
    private val mutex = Mutex()
    private var activeCallId: Long? = null
    private var outputFile: File? = null

    suspend fun startRecording(callInfo: CallInfo) {
        mutex.withLock {
            if (activeCallId != null) return
            if (!audioCaptureManager.hasProjection()) {
                throw IllegalStateException("MediaProjection not granted")
            }
            val callId = callRepository.createCallRecord(callInfo)
            val file = buildOutputFile(callId)
            activeCallId = callId
            outputFile = file
            withContext(dispatchers.io) {
                ContextCompat.startForegroundService(
                    context,
                    Intent(context, CallRecordingService::class.java).apply {
                        action = CallRecordingService.ACTION_START
                        putExtra(CallRecordingService.EXTRA_CALL_ID, callId)
                        putExtra(CallRecordingService.EXTRA_OUTPUT_PATH, file.absolutePath)
                    }
                )
            }
        }
    }

    suspend fun stopRecording() {
        mutex.withLock {
            val callId = activeCallId ?: return
            val path = outputFile?.absolutePath
            scope.launch {
                context.startService(
                    Intent(context, CallRecordingService::class.java).apply {
                        action = CallRecordingService.ACTION_STOP
                        putExtra(CallRecordingService.EXTRA_CALL_ID, callId)
                        putExtra(CallRecordingService.EXTRA_OUTPUT_PATH, path)
                    }
                )
            }
            activeCallId = null
        }
    }

    fun isRecording(): Boolean = audioCaptureManager.isCapturing()

    fun provideMediaProjection(projection: android.media.projection.MediaProjection) {
        audioCaptureManager.setMediaProjection(projection)
    }

    private fun buildOutputFile(callId: Long): File {
        val root = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC) ?: context.filesDir
        val dir = File(root, "call_recordings").apply { if (!exists()) mkdirs() }
        return File(dir, "call_${callId}.m4a")
    }
}
