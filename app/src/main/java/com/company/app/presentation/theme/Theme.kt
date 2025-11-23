package com.company.app.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    surface = SurfaceColor,
    onPrimary = TextPrimary,
    onBackground = TextPrimary
)

@Composable
fun ThreeSixZeroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
