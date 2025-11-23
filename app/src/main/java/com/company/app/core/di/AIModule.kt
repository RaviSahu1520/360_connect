package com.company.app.core.di

import com.company.app.data.local.vector.InMemoryVectorStore
import com.company.app.data.local.vector.VectorStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AIModule {

    @Provides
    @Singleton
    fun provideVectorStore(): VectorStore = InMemoryVectorStore()
}
