package com.company.app.core.di

import com.company.app.data.repository.AIRepositoryImpl
import com.company.app.data.repository.CallRepositoryImpl
import com.company.app.data.repository.ChatRepositoryImpl
import com.company.app.domain.repository.AIRepository
import com.company.app.domain.repository.CallRepository
import com.company.app.domain.repository.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindChatRepository(impl: ChatRepositoryImpl): ChatRepository

    @Binds
    @Singleton
    abstract fun bindCallRepository(impl: CallRepositoryImpl): CallRepository

    @Binds
    @Singleton
    abstract fun bindAIRepository(impl: AIRepositoryImpl): AIRepository
}
