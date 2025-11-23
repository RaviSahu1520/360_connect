package com.company.app.presentation

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.company.app.presentation.navigation.AppNavGraph
import com.company.app.presentation.permissions.PermissionType
import com.company.app.presentation.theme.ThreeSixZeroTheme
import com.company.app.platform.recording.AudioCaptureManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var audioCaptureManager: AudioCaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThreeSixZeroTheme {
                val navController = rememberNavController()
                val callbacks = remember { mutableStateMapOf<PermissionType, (Boolean) -> Unit>() }
                val micLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
                    callbacks.remove(PermissionType.MICROPHONE)?.invoke(granted)
                }
                val overlayLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    val granted = Settings.canDrawOverlays(this)
                    callbacks.remove(PermissionType.OVERLAY)?.invoke(granted)
                }
                val accessibilityLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    val granted = isAccessibilityEnabled()
                    callbacks.remove(PermissionType.ACCESSIBILITY)?.invoke(granted)
                }
                val notificationAccessLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    val granted = androidx.core.app.NotificationManagerCompat
                        .getEnabledListenerPackages(this)
                        .contains(packageName)
                    callbacks.remove(PermissionType.NOTIFICATION_LISTENER)?.invoke(granted)
                }
                val mediaProjectionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    val projectionManager = getSystemService(android.media.projection.MediaProjectionManager::class.java)
                    val projection = result.data?.let { projectionManager?.getMediaProjection(result.resultCode, it) }
                    val granted = projection != null
                    if (granted && projection != null) {
                        audioCaptureManager.setMediaProjection(projection)
                    }
                    callbacks.remove(PermissionType.MEDIA_PROJECTION)?.invoke(granted)
                }

                AppNavGraph(navController = navController) { type, callback ->
                    callbacks[type] = callback
                    when (type) {
                        PermissionType.MICROPHONE -> micLauncher.launch(Manifest.permission.RECORD_AUDIO)
                        PermissionType.OVERLAY -> overlayLauncher.launch(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${'$'}packageName")))
                        PermissionType.ACCESSIBILITY -> accessibilityLauncher.launch(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                        PermissionType.NOTIFICATION_LISTENER -> notificationAccessLauncher.launch(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
                        PermissionType.MEDIA_PROJECTION -> mediaProjectionLauncher.launch(audioCaptureManager.requestProjectionIntent())
                    }
                }
            }
        }
    }

    private fun isAccessibilityEnabled(): Boolean {
        val manager = getSystemService(AccessibilityManager::class.java) ?: return false
        return manager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
            .any { it.resolveInfo?.serviceInfo?.packageName == packageName }
    }
}
