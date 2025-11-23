package com.company.app.presentation.call

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CallScreen(
    state: CallUiState,
    onStartCall: (String) -> Unit,
    onEndCall: () -> Unit,
    onToggleMute: () -> Unit,
    onTranscribe: (String) -> Unit,
    onQueryRag: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val remoteUserId = remember { mutableStateOf("demo_user") }
    val audioPath = remember { mutableStateOf("/sdcard/Audio/demo.wav") }
    val query = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "VoIP Call", style = MaterialTheme.typography.headlineMedium)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = remoteUserId.value,
                onValueChange = { remoteUserId.value = it },
                label = { Text("User Id") },
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { onStartCall(remoteUserId.value) }) { Text("Call") }
            Button(onClick = onEndCall) { Text("End") }
        }
        Text(text = "Status: ${'$'}{state.connection.status}")
        Text(text = "Muted: ${'$'}{state.connection.isMuted}")
        Button(onClick = onToggleMute) { Text("Toggle Mute") }
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = audioPath.value,
                    onValueChange = { audioPath.value = it },
                    label = { Text("Audio Path") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { onTranscribe(audioPath.value) }, modifier = Modifier.padding(top = 8.dp)) {
                    Text("Transcribe")
                }
                Text(text = "Transcription: ${'$'}{state.transcriptionText}")
            }
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = query.value,
                    onValueChange = { query.value = it },
                    label = { Text("RAG Query") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = { onQueryRag(query.value) }) {
                    Text("Search")
                }
                state.aiError?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }
                state.aiAnswer?.let { Text(text = it) }
            }
        }
    }
}
