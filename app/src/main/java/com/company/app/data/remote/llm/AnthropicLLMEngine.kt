package com.company.app.data.remote.llm

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit

interface LLMEngine {
    suspend fun generateResponse(prompt: String): String
}

class AnthropicLLMEngine(
    private val baseUrl: String,
    private val apiKey: String,
    private val client: OkHttpClient,
    private val gson: Gson = Gson()
) : LLMEngine {

    private val mediaType = "application/json; charset=utf-8".toMediaType()

    override suspend fun generateResponse(prompt: String): String = withContext(Dispatchers.IO) {
        val requestPayload = AnthropicRequest(
            model = "claude-3-haiku-20240307",
            maxTokens = 1024,
            messages = listOf(AnthropicMessage(role = "user", content = prompt))
        )
        val requestBody = gson.toJson(requestPayload).toRequestBody(mediaType)
        val httpClient = client.newBuilder()
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url("${baseUrl.trimEnd('/')}/v1/messages")
            .post(requestBody)
            .addHeader("Authorization", "Bearer $apiKey")
            .addHeader("Content-Type", "application/json")
            .build()

        try {
            httpClient.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    return@withContext "Error: HTTP ${response.code} ${response.message}"
                }

                val bodyString = response.body?.string()
                if (bodyString.isNullOrBlank()) {
                    return@withContext "Error: Empty response"
                }

                val parsed = gson.fromJson(bodyString, AnthropicResponse::class.java)
                val text = parsed.content?.firstOrNull()?.text
                if (text.isNullOrBlank()) {
                    "Error: Empty response content"
                } else {
                    text
                }
            }
        } catch (e: IOException) {
            "Error: ${e.message ?: "Network error"}"
        } catch (e: Exception) {
            "Error: ${e.message ?: "Unexpected error"}"
        }
    }

    private data class AnthropicRequest(
        val model: String,
        @SerializedName("max_tokens") val maxTokens: Int,
        val messages: List<AnthropicMessage>
    )

    private data class AnthropicMessage(
        val role: String,
        val content: String
    )

    private data class AnthropicResponse(
        val content: List<AnthropicContent>?
    )

    private data class AnthropicContent(
        val text: String?
    )
}
