package com.company.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.app.data.local.vector.TranscriptEmbeddingEntity

@Dao
interface EmbeddingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(embedding: TranscriptEmbeddingEntity)

    @Query("SELECT * FROM embeddings")
    suspend fun getAll(): List<TranscriptEmbeddingEntity>

    @Query("SELECT * FROM embeddings WHERE callId = :callId")
    suspend fun getByCallId(callId: Long): List<TranscriptEmbeddingEntity>
}
