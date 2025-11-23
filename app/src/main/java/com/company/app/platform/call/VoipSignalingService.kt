package com.company.app.platform.call

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.company.app.data.remote.SignalingClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VoipSignalingService : Service() {

    @Inject lateinit var signalingClient: SignalingClient

    private val serviceScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        serviceScope.launch {
            signalingClient.connect().collect { /* TODO handle signaling frames */ }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}
