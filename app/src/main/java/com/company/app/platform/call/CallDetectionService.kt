package com.company.app.platform.call

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.app.Notification
import android.view.accessibility.AccessibilityEvent
import com.company.app.domain.model.CallInfo
import com.company.app.domain.model.CallType
import com.company.app.platform.recording.CallRecordingController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant

class CallDetectionService : AccessibilityService() {

    private lateinit var callRecordingController: CallRecordingController

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var recordingStarted = false

    override fun onCreate() {
        super.onCreate()
        // AccessibilityService is not directly supported by Hilt's @AndroidEntryPoint;
        // use an entry point to pull the dependency from the application component.
        val entryPoint = EntryPointAccessors.fromApplication(
            applicationContext,
            CallDetectionServiceEntryPoint::class.java
        )
        callRecordingController = entryPoint.callRecordingController()
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        serviceInfo = serviceInfo.apply {
            eventTypes = AccessibilityEvent.TYPES_ALL_MASK
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            notificationTimeout = 0
            flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS or
                AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val accessibilityEvent = event ?: return
        if (accessibilityEvent.eventType != AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) return
        val packageName = accessibilityEvent.packageName?.toString() ?: return
        if (!SUPPORTED_PACKAGES.contains(packageName)) return

        val notification = accessibilityEvent.parcelableData as? Notification ?: return
        val title = notification.extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val text = notification.extras.getCharSequence(Notification.EXTRA_TEXT)?.toString().orEmpty()
        val description = accessibilityEvent.text?.joinToString(" ").orEmpty()
        val payload = listOf(title, text, description).joinToString(" ").lowercase()

        when {
            isCallStart(payload) -> {
                val info = CallInfo(
                    remoteUserId = extractNumber(title, text) ?: "Unknown",
                    displayName = title.ifBlank { text },
                    type = inferType(payload),
                    source = "SYSTEM_CALL",
                    startedAt = Instant.fromEpochMilliseconds(accessibilityEvent.eventTime)
                )
                startRecordingIfNeeded(info)
            }
            isCallEnded(payload) -> stopRecordingIfNeeded()
        }
    }

    override fun onInterrupt() {
        stopRecordingIfNeeded()
    }

    private fun startRecordingIfNeeded(callInfo: CallInfo) {
        if (recordingStarted || callRecordingController.isRecording()) return
        recordingStarted = true
        serviceScope.launch {
            runCatching { callRecordingController.startRecording(callInfo) }
                .onFailure { recordingStarted = false }
        }
    }

    private fun stopRecordingIfNeeded() {
        if (!recordingStarted) return
        recordingStarted = false
        serviceScope.launch {
            runCatching { callRecordingController.stopRecording() }
        }
    }

    private fun isCallStart(payload: String): Boolean {
        val indicators = listOf("incoming call", "call from", "calling", "dialing", "ongoing call")
        return indicators.any { payload.contains(it) }
    }

    private fun isCallEnded(payload: String): Boolean {
        val endings = listOf("call ended", "missed call", "call finished", "call duration", "call disconnected")
        return endings.any { payload.contains(it) }
    }

    private fun inferType(payload: String): CallType = when {
        payload.contains("incoming") -> CallType.INCOMING
        payload.contains("missed") -> CallType.INCOMING
        payload.contains("dialing") || payload.contains("outgoing") -> CallType.OUTGOING
        else -> CallType.INCOMING
    }

    private fun extractNumber(title: String, text: String): String? {
        val combined = listOf(title, text).joinToString(" ")
        val number = combined.filter { it.isDigit() || it == '+' || it == '-' || it == ' ' }
            .trim()
        return number.takeIf { it.isNotBlank() } ?: combined.takeIf { it.isNotBlank() }
    }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface CallDetectionServiceEntryPoint {
        fun callRecordingController(): CallRecordingController
    }

    companion object {
        private val SUPPORTED_PACKAGES = setOf(
            "com.google.android.dialer",
            "com.samsung.android.incallui",
            "com.android.server.telecom"
        )
    }
}
