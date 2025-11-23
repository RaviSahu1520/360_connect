package com.company.app.presentation.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.app.core.util.DateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallHistoryScreen(
    state: CallHistoryUiState,
    onSelectCall: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Call History") }) }
    ) { padding ->
        when {
            state.isLoading -> Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
            state.error != null -> Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.error, color = MaterialTheme.colorScheme.error)
            }
            else -> LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.items) { item ->
                    CallHistoryRow(item, onSelectCall)
                }
            }
        }
    }
}

@Composable
private fun CallHistoryRow(
    item: CallHistoryItemUi,
    onSelectCall: (Long) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { onSelectCall(item.callId) }
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = item.remoteUserLabel, style = MaterialTheme.typography.titleMedium)
                    Text(text = item.typeLabel, style = MaterialTheme.typography.bodySmall)
                }
                StatusChip(item.transcriptionStatus)
            }
            Text(text = DateUtils.formatDateTime(item.timestamp), style = MaterialTheme.typography.bodySmall)
            Text(text = "Duration: ${item.durationFormatted}", style = MaterialTheme.typography.bodySmall)
            item.summaryPreview?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
private fun StatusChip(status: String) {
    val (label, color) = when (status) {
        "COMPLETED" -> "Ready" to MaterialTheme.colorScheme.primary
        "FAILED" -> "Failed" to MaterialTheme.colorScheme.error
        else -> "Transcribing..." to MaterialTheme.colorScheme.secondary
    }
    Text(
        text = label,
        color = color,
        style = MaterialTheme.typography.labelMedium
    )
}
