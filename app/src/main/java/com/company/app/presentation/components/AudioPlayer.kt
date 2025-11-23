package com.company.app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AudioPlayer(
    title: String,
    modifier: Modifier = Modifier
) {
    val progress = remember { mutableStateOf(0f) }
    Row(modifier = modifier.padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = title)
        Slider(value = progress.value, onValueChange = { progress.value = it })
        Button(onClick = { /*TODO hook to ExoPlayer*/ }) {
            Text(text = "Play")
        }
    }
}
