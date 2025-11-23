package com.company.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.ws
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SignalingClient(private val baseUrl: String) {
    private val httpClient = HttpClient { install(WebSockets) }

    suspend fun connect(): Flow<String> = flow {
        httpClient.ws(method = HttpMethod.Get, host = baseUrl, path = "/signaling") {
            for (frame in incoming) {
                if (frame is Frame.Text) emit(frame.readText())
            }
        }
    }
}
