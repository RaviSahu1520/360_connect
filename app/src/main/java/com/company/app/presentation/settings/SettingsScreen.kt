package com.company.app.presentation.settings

import androidx.compose.runtime.Composable
import com.company.app.presentation.permissions.PermissionChecklistState
import com.company.app.presentation.permissions.PermissionType

@Composable
fun SettingsScreen(
    isReady: Boolean,
    permissionState: PermissionChecklistState,
    onDownloadModels: () -> Unit,
    onRequestPermission: (PermissionType) -> Unit
) {
    ModelManagementScreen(
        isReady = isReady,
        permissionState = permissionState,
        onDownloadModels = onDownloadModels,
        onRequestPermission = onRequestPermission
    )
}
