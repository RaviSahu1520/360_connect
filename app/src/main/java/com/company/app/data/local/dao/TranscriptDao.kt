package com.company.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.app.data.local.entity.TranscriptEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TranscriptDao {
    @Query("SELECT * FROM transcripts WHERE callId = :callId")
    fun observeTranscript(callId: Long): Flow<TranscriptEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(transcript: TranscriptEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transcript: TranscriptEntity): Long

    @Query("SELECT * FROM transcripts WHERE id = :id")
    suspend fun getById(id: Long): TranscriptEntity?

    @Query("SELECT * FROM transcripts WHERE callId = :callId LIMIT 1")
    suspend fun findByCallId(callId: Long): TranscriptEntity?

    @Query("UPDATE transcripts SET summary=:summary, timestamp=:timestamp WHERE id=:id")
    suspend fun updateSummary(id: Long, summary: String, timestamp: Long)

    @Query("UPDATE transcripts SET fullText=:text, timestamp=:timestamp WHERE id=:id")
    suspend fun updateTranscript(id: Long, text: String, timestamp: Long)
}
