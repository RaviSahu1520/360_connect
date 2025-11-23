package com.company.app.core.di

import com.company.app.core.common.DefaultDispatcherProvider
import com.company.app.core.common.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun provideDispatchers(): DispatcherProvider = DefaultDispatcherProvider()
}
