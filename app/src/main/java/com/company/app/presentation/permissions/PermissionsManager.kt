package com.company.app.presentation.permissions

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.company.app.platform.recording.AudioCaptureManager
import com.company.app.presentation.permissions.PermissionStatus.Denied
import com.company.app.presentation.permissions.PermissionStatus.Granted
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PermissionsManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val audioCaptureManager: AudioCaptureManager
) {

    private val _state = MutableStateFlow(PermissionChecklistState(permissionSnapshot()))
    val state: StateFlow<PermissionChecklistState> = _state.asStateFlow()

    fun refresh() {
        _state.value = PermissionChecklistState(permissionSnapshot())
    }

    fun mark(type: PermissionType, granted: Boolean) {
        val current = _state.value.items.toMutableMap()
        current[type] = if (granted) Granted else Denied
        _state.value = PermissionChecklistState(current)
    }

    private fun permissionSnapshot(): Map<PermissionType, PermissionStatus> {
        return mapOf(
            PermissionType.MICROPHONE to microphoneStatus(),
            PermissionType.OVERLAY to overlayStatus(),
            PermissionType.ACCESSIBILITY to accessibilityStatus(),
            PermissionType.NOTIFICATION_LISTENER to notificationStatus(),
            PermissionType.MEDIA_PROJECTION to mediaProjectionStatus()
        )
    }

    private fun microphoneStatus(): PermissionStatus {
        val granted = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.RECORD_AUDIO
        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        return if (granted) Granted else Denied
    }

    private fun overlayStatus(): PermissionStatus {
        val allowed = Settings.canDrawOverlays(context)
        return if (allowed) Granted else Denied
    }

    private fun accessibilityStatus(): PermissionStatus {
        val manager = context.getSystemService(AccessibilityManager::class.java) ?: return Denied
        val enabledList = manager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
        val granted = enabledList.any { it.resolveInfo?.serviceInfo?.packageName == context.packageName }
        return if (granted) Granted else Denied
    }

    private fun notificationStatus(): PermissionStatus {
        val granted = NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.packageName)
        return if (granted) Granted else Denied
    }

    private fun mediaProjectionStatus(): PermissionStatus {
        return if (audioCaptureManager.hasProjection()) Granted else Denied
    }
}
