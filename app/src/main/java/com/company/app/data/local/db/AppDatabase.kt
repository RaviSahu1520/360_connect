package com.company.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.company.app.data.local.dao.CallDao
import com.company.app.data.local.dao.MessageDao
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.entity.CallEntity
import com.company.app.data.local.entity.MessageEntity
import com.company.app.data.local.entity.TranscriptEntity

@Database(
    entities = [MessageEntity::class, CallEntity::class, TranscriptEntity::class],
    version = 3,
    exportSchema = true
)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun callDao(): CallDao
    abstract fun transcriptDao(): TranscriptDao
}
