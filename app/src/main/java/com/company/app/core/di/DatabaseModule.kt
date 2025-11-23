package com.company.app.core.di

import android.content.Context
import androidx.room.Room
import com.company.app.core.security.EncryptionManager
import com.company.app.core.security.KeyStoreHelper
import com.company.app.data.local.dao.CallDao
import com.company.app.data.local.dao.MessageDao
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app-db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMessageDao(appDatabase: AppDatabase): MessageDao = appDatabase.messageDao()

    @Provides
    fun provideCallDao(appDatabase: AppDatabase): CallDao = appDatabase.callDao()

    @Provides
    fun provideTranscriptDao(appDatabase: AppDatabase): TranscriptDao = appDatabase.transcriptDao()

    @Provides
    @Singleton
    fun provideEncryptionManager(): EncryptionManager =
        EncryptionManager(KeyStoreHelper(alias = "app-key"))
}
