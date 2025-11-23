package com.company.app.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.app.core.util.DateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallDetailScreen(
    callId: Long,
    state: CallDetailUiState,
    onLoad: (Long) -> Unit,
    onAsk: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(callId) { onLoad(callId) }
    val query = remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Call Detail") }) }
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
            else -> Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                state.header?.let { header ->
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = header.remoteUserLabel, style = MaterialTheme.typography.titleLarge)
                        Text(text = header.typeLabel, style = MaterialTheme.typography.bodyMedium)
                        Text(text = DateUtils.formatDateTime(header.timestamp), style = MaterialTheme.typography.bodySmall)
                        Text(text = "Duration: ${header.durationFormatted}", style = MaterialTheme.typography.bodySmall)
                        Text(text = "Status: ${header.transcriptionStatus}", style = MaterialTheme.typography.bodySmall)
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Summary", style = MaterialTheme.typography.titleMedium)
                    Text(text = state.summary ?: "No summary available yet")
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Transcript", style = MaterialTheme.typography.titleMedium)
                    Text(text = state.transcript ?: "No transcript yet")
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Ask AI about this call", style = MaterialTheme.typography.titleMedium)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = query.value,
                            onValueChange = { query.value = it },
                            label = { Text("Enter your question") },
                            modifier = Modifier.weight(1f)
                        )
                        Button(onClick = { onAsk(query.value) }) {
                            Text("Ask")
                        }
                    }
                    if (state.aiIsLoading) {
                        CircularProgressIndicator()
                    }
                    state.aiError?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }
                    state.aiAnswer?.let { Text(text = it) }
                }
                Spacer(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
