package com.company.app.platform.call

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

enum class CallStatus { Idle, Connecting, InCall, Ended, Failed }

data class CallConnectionState(
    val status: CallStatus = CallStatus.Idle,
    val isMuted: Boolean = false,
    val remoteUserId: String = ""
)

@Singleton
class VoipClient @Inject constructor() {

    private val _state = MutableStateFlow(CallConnectionState())
    val state: StateFlow<CallConnectionState> = _state.asStateFlow()

    suspend fun startCall(remoteUserId: String) {
        _state.value = CallConnectionState(CallStatus.Connecting, false, remoteUserId)
        delay(500)
        _state.value = CallConnectionState(CallStatus.InCall, false, remoteUserId)
    }

    fun toggleMute() {
        val current = _state.value
        _state.value = current.copy(isMuted = !current.isMuted)
    }

    fun endCall() {
        val current = _state.value
        _state.value = current.copy(status = CallStatus.Ended)
    }
}
