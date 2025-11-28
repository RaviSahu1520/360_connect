package com.company.app.presentation.permissions

import android.Manifest
import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessibilityNew
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Layers
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.NotificationsActive
import androidx.compose.material.icons.outlined.ScreenShare
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.company.app.platform.recording.AudioCaptureManager
import com.company.app.platform.accessibility.accessibilitySettingsIntents
import com.company.app.presentation.navigation.AppNavGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private data class PermissionStepDefinition(
    val type: PermissionType,
    val title: String,
    val rationale: String,
    val icon: ImageVector
)

data class PermissionStepUi(
    val type: PermissionType,
    val title: String,
    val rationale: String,
    val icon: ImageVector,
    val status: PermissionStatus
)

data class PermissionOnboardingUiState(
    val steps: List<PermissionStepUi> = emptyList(),
    val currentIndex: Int = 0,
    val allGranted: Boolean = false
) {
    val currentStep: PermissionStepUi? get() = steps.getOrNull(currentIndex)
}

sealed class PermissionCommand {
    data class Request(val type: PermissionType) : PermissionCommand()
}

@HiltViewModel
class PermissionOnboardingViewModel @Inject constructor(
    private val permissionsManager: PermissionsManager
) : ViewModel() {

    private val currentIndex = MutableStateFlow(0)
    private val _commands = MutableSharedFlow<PermissionCommand>()
    val commands: SharedFlow<PermissionCommand> = _commands

    private val definitions = listOf(
        PermissionStepDefinition(
            type = PermissionType.MICROPHONE,
            title = "Microphone",
            rationale = "Capture call audio so you get high-quality transcripts and summaries.",
            icon = Icons.Outlined.Mic
        ),
        PermissionStepDefinition(
            type = PermissionType.OVERLAY,
            title = "Overlay",
            rationale = "Show quick controls over the dialer while recording runs in the foreground.",
            icon = Icons.Outlined.Layers
        ),
        PermissionStepDefinition(
            type = PermissionType.ACCESSIBILITY,
            title = "Accessibility Service",
            rationale = "Detects call screens to start and stop recording automatically.",
            icon = Icons.Outlined.AccessibilityNew
        ),
        PermissionStepDefinition(
            type = PermissionType.NOTIFICATION_LISTENER,
            title = "Notification Access",
            rationale = "Listens to call notifications to keep detection reliable across devices.",
            icon = Icons.Outlined.NotificationsActive
        ),
        PermissionStepDefinition(
            type = PermissionType.MEDIA_PROJECTION,
            title = "Screen & Audio Capture",
            rationale = "Captures device audio via MediaProjection for crystal-clear recordings.",
            icon = Icons.Outlined.ScreenShare
        )
    )

    val uiState = combine(
        permissionsManager.state,
        currentIndex
    ) { permissionState, index ->
        val steps = definitions.map { def ->
            PermissionStepUi(
                type = def.type,
                title = def.title,
                rationale = def.rationale,
                icon = def.icon,
                status = permissionState.items[def.type] ?: PermissionStatus.Denied
            )
        }
        PermissionOnboardingUiState(
            steps = steps,
            currentIndex = index.coerceIn(0, steps.lastIndex),
            allGranted = steps.all { it.status is PermissionStatus.Granted }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = PermissionOnboardingUiState(
            steps = definitions.map { def ->
                PermissionStepUi(
                    type = def.type,
                    title = def.title,
                    rationale = def.rationale,
                    icon = def.icon,
                    status = PermissionStatus.Denied
                )
            }
        )
    )

    init {
        permissionsManager.refresh()
    }

    fun onGrantClicked() {
        uiState.value.currentStep?.let { step ->
            requestPermission(step.type)
        }
    }

    fun requestPermission(type: PermissionType) {
        viewModelScope.launch {
            _commands.emit(PermissionCommand.Request(type))
        }
    }

    fun onPermissionResult(type: PermissionType, granted: Boolean) {
        permissionsManager.mark(type, granted)
        permissionsManager.refresh()
        if (granted && uiState.value.currentStep?.type == type) moveNext()
    }

    fun moveNext() {
        val newIndex = (currentIndex.value + 1).coerceAtMost(definitions.lastIndex)
        currentIndex.value = newIndex
    }

    fun movePrevious() {
        val newIndex = (currentIndex.value - 1).coerceAtLeast(0)
        currentIndex.value = newIndex
    }
}

@Composable
fun PermissionOnboardingScreen(
    state: PermissionOnboardingUiState,
    onGrant: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    val step = state.currentStep ?: return
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.background.copy(alpha = 0.85f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = "360 Connect setup",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Enable secure, reliable call capture in a few quick steps.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                )
                StepIndicator(
                    steps = state.steps,
                    currentIndex = state.currentIndex
                )
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = step.icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Column {
                                Text(
                                    text = step.title,
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
                                )
                                PermissionStatusChip(status = step.status)
                            }
                        }
                        Text(
                            text = step.rationale,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
                        )
                        Text(
                            text = when (step.type) {
                                PermissionType.MICROPHONE -> "Used only while recording calls you start; audio stays private on your device until you choose to share."
                                PermissionType.OVERLAY -> "Lets 360 Connect show a small control over other apps so you can pause or stop quickly."
                                PermissionType.ACCESSIBILITY -> "Allows 360 Connect to detect call UIs across dialer apps for consistent start/stop automation."
                                PermissionType.NOTIFICATION_LISTENER -> "Reads call-related notifications to detect incoming/outgoing calls without accessing your personal messages."
                                PermissionType.MEDIA_PROJECTION -> "Requests a one-time screen & audio capture token from Android's MediaProjection system."
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                        )
                        Button(
                            onClick = onGrant,
                            modifier = Modifier.fillMaxWidth(),
                            enabled = step.status !is PermissionStatus.Granted
                        ) {
                            Text(
                                text = if (step.status is PermissionStatus.Granted) "Granted" else "Grant permission"
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OutlinedButton(
                                onClick = onPrevious,
                                modifier = Modifier.weight(1f),
                                enabled = state.currentIndex > 0
                            ) {
                                Text("Previous")
                            }
                            Button(
                                onClick = onNext,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(if (state.currentIndex == state.steps.lastIndex) "Review" else "Next")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StepIndicator(
    steps: List<PermissionStepUi>,
    currentIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        steps.forEachIndexed { index, step ->
            val isActive = index <= currentIndex
            val isGranted = step.status is PermissionStatus.Granted
            val color = when {
                isGranted -> MaterialTheme.colorScheme.primary
                isActive -> MaterialTheme.colorScheme.secondary
                else -> MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(color)
            )
        }
    }
}

@Composable
private fun PermissionStatusChip(status: PermissionStatus) {
    val (text, tint) = when (status) {
        PermissionStatus.Granted -> "Granted" to MaterialTheme.colorScheme.primary
        PermissionStatus.NeedsRationale -> "Explain needed" to MaterialTheme.colorScheme.secondary
        PermissionStatus.Denied -> "Required" to MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(tint.copy(alpha = 0.15f))
                .padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                tint = tint,
                contentDescription = null
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = tint
        )
    }
}

@Composable
fun MainScreen(
    audioCaptureManager: AudioCaptureManager,
    onAllPermissionsGranted: () -> Unit = {}
) {
    val context = LocalContext.current
    val packageName = context.packageName
    val viewModel: PermissionOnboardingViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val callbacks = remember { mutableStateMapOf<PermissionType, MutableList<(Boolean) -> Unit>>() }

    val micLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        handlePermissionResult(
            type = PermissionType.MICROPHONE,
            granted = granted,
            viewModel = viewModel,
            callbacks = callbacks
        )
    }

    val overlayLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val granted = Settings.canDrawOverlays(context)
        handlePermissionResult(
            type = PermissionType.OVERLAY,
            granted = granted,
            viewModel = viewModel,
            callbacks = callbacks
        )
    }

    val accessibilityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val manager = context.getSystemService(android.view.accessibility.AccessibilityManager::class.java)
        val granted = manager
            ?.getEnabledAccessibilityServiceList(android.accessibilityservice.AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
            ?.any { it.resolveInfo?.serviceInfo?.packageName == packageName } == true
        handlePermissionResult(
            type = PermissionType.ACCESSIBILITY,
            granted = granted,
            viewModel = viewModel,
            callbacks = callbacks
        )
    }

    val notificationAccessLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val granted = androidx.core.app.NotificationManagerCompat
            .getEnabledListenerPackages(context)
            .contains(packageName)
        handlePermissionResult(
            type = PermissionType.NOTIFICATION_LISTENER,
            granted = granted,
            viewModel = viewModel,
            callbacks = callbacks
        )
    }

    val mediaProjectionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val projectionManager = context.getSystemService(MediaProjectionManager::class.java)
        val projection = result.data?.let { data ->
            projectionManager?.getMediaProjection(result.resultCode, data)
        }
        val granted = projection != null
        projection?.let { audioCaptureManager.setMediaProjection(it) }
        handlePermissionResult(
            type = PermissionType.MEDIA_PROJECTION,
            granted = granted,
            viewModel = viewModel,
            callbacks = callbacks
        )
    }

    LaunchedEffect(Unit) {
        viewModel.commands.collect { command ->
            when (command) {
                is PermissionCommand.Request -> {
                    when (command.type) {
                        PermissionType.MICROPHONE -> micLauncher.launch(Manifest.permission.RECORD_AUDIO)
                        PermissionType.OVERLAY -> overlayLauncher.launch(
                            Intent(
                                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:$packageName")
                            )
                        )
                        PermissionType.ACCESSIBILITY -> {
                            val targetIntent = context
                                .accessibilitySettingsIntents()
                                .firstOrNull { intent ->
                                    intent.resolveActivity(context.packageManager) != null
                                }
                            if (targetIntent != null) {
                                accessibilityLauncher.launch(targetIntent)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Unable to open Accessibility Settings",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                        PermissionType.NOTIFICATION_LISTENER -> notificationAccessLauncher.launch(
                            Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                        )
                        PermissionType.MEDIA_PROJECTION -> {
                            val projectionIntent = audioCaptureManager.requestProjectionIntent()
                            mediaProjectionLauncher.launch(projectionIntent)
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(state.allGranted) {
        if (state.allGranted) onAllPermissionsGranted()
    }

    Crossfade(targetState = state.allGranted, label = "onboarding") { allGranted ->
        if (!allGranted) {
            PermissionOnboardingScreen(
                state = state,
                onGrant = viewModel::onGrantClicked,
                onNext = viewModel::moveNext,
                onPrevious = viewModel::movePrevious,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            AppNavGraph(
                navController = navController,
                onPermissionAction = { type, callback ->
                    val list = callbacks.getOrPut(type) { mutableListOf() }
                    list.add(callback)
                    viewModel.requestPermission(type)
                }
            )
        }
    }
}

private fun handlePermissionResult(
    type: PermissionType,
    granted: Boolean,
    viewModel: PermissionOnboardingViewModel,
    callbacks: MutableMap<PermissionType, MutableList<(Boolean) -> Unit>>
) {
    viewModel.onPermissionResult(type, granted)
    callbacks.remove(type)?.forEach { callback -> callback(granted) }
}
