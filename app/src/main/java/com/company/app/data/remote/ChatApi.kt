package com.company.app.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApi {
    @POST("/auth/login")
    suspend fun login(@Body payload: Map<String, String>): Map<String, String>

    @GET("/keys/public/{userId}")
    suspend fun getPublicKey(@Path("userId") userId: String): Map<String, String>

    @POST("/sync/messages")
    suspend fun syncMessages(@Body payload: Map<String, Any>): Map<String, Any>
}
