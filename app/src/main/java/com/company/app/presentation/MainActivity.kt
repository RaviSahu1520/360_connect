package com.company.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.company.app.presentation.permissions.MainScreen
import com.company.app.presentation.theme.ThreeSixZeroTheme
import com.company.app.platform.recording.AudioCaptureManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var audioCaptureManager: AudioCaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThreeSixZeroTheme {
                MainScreen(audioCaptureManager = audioCaptureManager)
            }
        }
    }
}
