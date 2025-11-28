package com.company.app.core.di

import com.company.app.BuildConfig
import com.company.app.data.local.dao.EmbeddingDao
import com.company.app.data.local.db.AppDatabase
import com.company.app.data.local.vector.EmbeddingConverters
import com.company.app.data.local.vector.RoomVectorStore
import com.company.app.data.local.vector.VectorStore
import com.company.app.data.remote.llm.AnthropicLLMEngine
import com.company.app.data.remote.llm.LLMEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AIModule {

    @Provides
    @Singleton
    fun provideEmbeddingDao(db: AppDatabase): EmbeddingDao = db.embeddingDao()

    @Provides
    @Singleton
    fun provideEmbeddingConverters(): EmbeddingConverters = EmbeddingConverters()

    @Provides
    @Singleton
    fun provideVectorStore(
        dao: EmbeddingDao,
        converters: EmbeddingConverters
    ): VectorStore = RoomVectorStore(dao, converters)

    @Provides
    @Singleton
    fun provideLLMEngine(okHttpClient: OkHttpClient): LLMEngine {
        return AnthropicLLMEngine(
            baseUrl = BuildConfig.ANTHROPIC_BASE_URL,
            apiKey = BuildConfig.ANTHROPIC_AUTH_TOKEN,
            client = okHttpClient
        )
    }
}
