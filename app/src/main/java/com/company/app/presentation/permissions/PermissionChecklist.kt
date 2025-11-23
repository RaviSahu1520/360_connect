package com.company.app.presentation.permissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PermissionChecklist(
    state: PermissionChecklistState,
    onRequestPermission: (PermissionType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        state.items.forEach { (type, status) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val icon = if (status is PermissionStatus.Granted) Icons.Outlined.CheckCircle else Icons.Outlined.Warning
                    Icon(imageVector = icon, contentDescription = null)
                    Column {
                        Text(text = type.readableName(), style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = status.readableStatus(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                if (status !is PermissionStatus.Granted) {
                    Button(onClick = { onRequestPermission(type) }) {
                        Text(text = "Grant")
                    }
                }
            }
        }
    }
}

private fun PermissionType.readableName(): String = when (this) {
    PermissionType.MICROPHONE -> "Microphone"
    PermissionType.ACCESSIBILITY -> "Accessibility"
    PermissionType.OVERLAY -> "Overlay"
    PermissionType.NOTIFICATION_LISTENER -> "Notification Access"
    PermissionType.MEDIA_PROJECTION -> "MediaProjection"
}

private fun PermissionStatus.readableStatus(): String = when (this) {
    PermissionStatus.Granted -> "Granted"
    PermissionStatus.Denied -> "Required"
    PermissionStatus.NeedsRationale -> "Explain why"
}
