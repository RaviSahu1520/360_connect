package com.company.app.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.app.core.util.DateUtils
import com.company.app.domain.model.Call
import com.company.app.presentation.permissions.PermissionChecklist
import com.company.app.presentation.permissions.PermissionType

@Composable
fun HomeScreen(
    state: HomeUiState,
    onStartChat: () -> Unit,
    onStartCall: () -> Unit,
    onOpenHistory: () -> Unit,
    onAskAi: () -> Unit,
    onPermissionAction: (PermissionType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "360 Connect", style = MaterialTheme.typography.headlineMedium)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(modifier = Modifier.weight(1f), onClick = onStartChat) {
                Text(text = "Open Chats")
            }
            Button(modifier = Modifier.weight(1f), onClick = onStartCall) {
                Text(text = "New Call")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(modifier = Modifier.weight(1f), onClick = onOpenHistory) {
                Text(text = "Call History")
            }
            Button(modifier = Modifier.weight(1f), onClick = onAskAi) {
                Text(text = "Ask AI")
            }
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Permissions", style = MaterialTheme.typography.titleMedium)
                PermissionChecklist(
                    state = state.permissionState,
                    onRequestPermission = onPermissionAction
                )
            }
        }
        Text(text = "Recent Calls", style = MaterialTheme.typography.titleMedium)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.calls) { call ->
                CallCard(call)
            }
        }
    }
}

@Composable
private fun CallCard(call: Call) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = call.remoteUserId, style = MaterialTheme.typography.titleMedium)
            Text(text = call.type.name)
            Text(text = DateUtils.formatDateTime(call.timestamp.toEpochMilliseconds()))
        }
    }
}
