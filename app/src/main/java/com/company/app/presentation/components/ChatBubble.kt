package com.company.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.company.app.domain.model.Message
import com.company.app.presentation.theme.Secondary
import com.company.app.presentation.theme.SurfaceColor

@Composable
fun ChatBubble(message: Message, modifier: Modifier = Modifier) {
    val background = if (message.isLocalUser) Secondary else SurfaceColor
    val alignmentPadding = if (message.isLocalUser) 48.dp else 0.dp
    Column(
        modifier = modifier
            .padding(start = alignmentPadding)
            .clip(RoundedCornerShape(18.dp))
            .background(background)
            .padding(16.dp)
    ) {
        Text(text = message.content, style = MaterialTheme.typography.bodyLarge)
    }
}
