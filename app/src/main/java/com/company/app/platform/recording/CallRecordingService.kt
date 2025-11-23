package com.company.app.platform.recording

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.company.app.R
import com.company.app.core.common.DispatcherProvider
import com.company.app.domain.repository.CallRepository
import com.company.app.workers.EmbeddingWorker
import com.company.app.workers.SummarizationWorker
import com.company.app.workers.TranscriptionWorker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@AndroidEntryPoint
class CallRecordingService : Service() {

    @Inject lateinit var audioCaptureManager: AudioCaptureManager
    @Inject lateinit var callRepository: CallRepository
    @Inject lateinit var dispatchers: DispatcherProvider

    private lateinit var serviceScope: CoroutineScope
    private var callId: Long = -1L
    private var outputPath: String? = null
    private var startedAt: Long = 0L

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        serviceScope = CoroutineScope(SupervisorJob() + dispatchers.io)
        ensureNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> handleStart(intent)
            ACTION_STOP -> handleStop(intent)
        }
        return START_STICKY
    }

    private fun handleStart(intent: Intent) {
        callId = intent.getLongExtra(EXTRA_CALL_ID, -1L)
        outputPath = intent.getStringExtra(EXTRA_OUTPUT_PATH)
        if (callId <= 0 || outputPath.isNullOrBlank() || !audioCaptureManager.hasProjection()) {
            stopSelf()
            return
        }
        startedAt = System.currentTimeMillis()
        startForegroundWithType()
        serviceScope.launch {
            audioCaptureManager.startCapture(File(outputPath!!))
        }
    }

    private fun handleStop(intent: Intent?) {
        if (callId <= 0) {
            callId = intent?.getLongExtra(EXTRA_CALL_ID, -1L) ?: callId
        }
        if (outputPath.isNullOrBlank()) {
            outputPath = intent?.getStringExtra(EXTRA_OUTPUT_PATH) ?: outputPath
        }
        serviceScope.launch {
            audioCaptureManager.stopCapture()
            val path = outputPath
            if (callId > 0 && !path.isNullOrBlank()) {
                val duration = System.currentTimeMillis() - startedAt
                callRepository.markCallCompleted(callId, path!!, duration)
                enqueueWorkers(callId, path)
            }
            stopForeground(STOP_FOREGROUND_REMOVE)
            stopSelf()
        }
    }

    private fun enqueueWorkers(callId: Long, audioPath: String) {
        val transcription = OneTimeWorkRequestBuilder<TranscriptionWorker>()
            .setInputData(
                workDataOf(
                    TranscriptionWorker.KEY_AUDIO_PATH to audioPath,
                    TranscriptionWorker.KEY_CALL_ID to callId
                )
            )
            .build()
        val summary = OneTimeWorkRequestBuilder<SummarizationWorker>()
            .setInputData(
                workDataOf(
                    TranscriptionWorker.KEY_CALL_ID to callId,
                    TranscriptionWorker.KEY_AUDIO_PATH to audioPath
                )
            )
            .setInputMerger(androidx.work.OverwritingInputMerger::class.java)
            .build()
        val embedding = OneTimeWorkRequestBuilder<EmbeddingWorker>()
            .setInputData(
                workDataOf(
                    TranscriptionWorker.KEY_CALL_ID to callId,
                    TranscriptionWorker.KEY_AUDIO_PATH to audioPath
                )
            )
            .setInputMerger(androidx.work.OverwritingInputMerger::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .beginUniqueWork("call_pipeline_${callId}", ExistingWorkPolicy.REPLACE, transcription)
            .then(summary)
            .then(embedding)
            .enqueue()
    }

    private fun ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Call Recording",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun buildNotification(): Notification = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Recording Call Audio...")
        .setContentText("Recording in progress")
        .setOngoing(true)
        .build()

    private fun startForegroundWithType() {
        val notification = buildNotification()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION or ServiceInfo.FOREGROUND_SERVICE_TYPE_MICROPHONE
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    companion object {
        const val ACTION_START = "call_recording_start"
        const val ACTION_STOP = "call_recording_stop"
        const val EXTRA_CALL_ID = "extra_call_id"
        const val EXTRA_OUTPUT_PATH = "extra_output_path"
        private const val CHANNEL_ID = "call_recording_channel"
        private const val NOTIFICATION_ID = 1330
    }
}
