package com.company.app.presentation.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.app.presentation.components.ChatBubble
import com.company.app.presentation.components.MessageInput

@Composable
fun ChatScreen(
    state: ChatUiState,
    onMessageChanged: (String) -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            reverseLayout = false
        ) {
            items(state.messages) { message ->
                ChatBubble(message = message, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
        MessageInput(
            value = state.input,
            onValueChange = onMessageChanged,
            onSend = onSend,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
    }
}
