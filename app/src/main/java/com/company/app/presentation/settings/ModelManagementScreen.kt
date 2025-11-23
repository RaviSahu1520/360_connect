package com.company.app.presentation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.app.presentation.permissions.PermissionChecklistState
import com.company.app.presentation.permissions.PermissionStatus
import com.company.app.presentation.permissions.PermissionType

@Composable
fun ModelManagementScreen(
    isReady: Boolean,
    permissionState: PermissionChecklistState,
    onDownloadModels: () -> Unit,
    onRequestPermission: (PermissionType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Model Management", style = MaterialTheme.typography.headlineSmall)
        Text(text = if (isReady) "All models installed" else "Models pending download")
        Button(onClick = onDownloadModels) {
            Text(text = "Download / Verify Models")
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "Call Recording Status", style = MaterialTheme.typography.titleMedium)
                PermissionRow(
                    title = "Enable Accessibility Service",
                    status = permissionState.items[PermissionType.ACCESSIBILITY] ?: PermissionStatus.Denied
                ) { onRequestPermission(PermissionType.ACCESSIBILITY) }
                PermissionRow(
                    title = "Enable Notification Listener",
                    status = permissionState.items[PermissionType.NOTIFICATION_LISTENER] ?: PermissionStatus.Denied
                ) { onRequestPermission(PermissionType.NOTIFICATION_LISTENER) }
                PermissionRow(
                    title = "Enable MediaProjection",
                    status = permissionState.items[PermissionType.MEDIA_PROJECTION] ?: PermissionStatus.Denied
                ) { onRequestPermission(PermissionType.MEDIA_PROJECTION) }
            }
        }
    }
}

@Composable
private fun PermissionRow(
    title: String,
    status: PermissionStatus,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val icon = if (status is PermissionStatus.Granted) Icons.Outlined.CheckCircle else Icons.Outlined.Warning
            Icon(imageVector = icon, contentDescription = null)
            Column {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                val subtitle = when (status) {
                    PermissionStatus.Granted -> "Granted"
                    PermissionStatus.Denied -> "Tap to enable"
                    PermissionStatus.NeedsRationale -> "Requires explanation"
                }
                Text(text = subtitle, style = MaterialTheme.typography.bodySmall)
            }
        }
        if (status !is PermissionStatus.Granted) {
            Button(onClick = onClick) { Text(text = "Enable") }
        }
    }
}
