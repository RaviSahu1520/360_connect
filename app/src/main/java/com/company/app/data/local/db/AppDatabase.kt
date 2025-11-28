package com.company.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.company.app.data.local.dao.CallDao
import com.company.app.data.local.dao.EmbeddingDao
import com.company.app.data.local.dao.MessageDao
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.entity.CallEntity
import com.company.app.data.local.entity.MessageEntity
import com.company.app.data.local.entity.TranscriptEntity
import com.company.app.data.local.vector.EmbeddingConverters
import com.company.app.data.local.vector.TranscriptEmbeddingEntity

@Database(
    entities = [MessageEntity::class, CallEntity::class, TranscriptEntity::class, TranscriptEmbeddingEntity::class],
    version = 4,
    exportSchema = true
)
@TypeConverters(AppTypeConverters::class, EmbeddingConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun callDao(): CallDao
    abstract fun transcriptDao(): TranscriptDao
    abstract fun embeddingDao(): EmbeddingDao
}
