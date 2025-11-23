package com.company.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.company.app.data.local.entity.CallEntity
import com.company.app.data.local.model.CallWithTranscriptLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CallDao {
    @Query("SELECT * FROM calls ORDER BY timestamp DESC")
    fun observeCalls(): Flow<List<CallEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(call: CallEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(call: CallEntity): Long

    @Query("UPDATE calls SET transcriptionStatus=:status WHERE id=:id")
    suspend fun updateStatus(id: Long, status: String)

    @Query("UPDATE calls SET transcriptionStatus=:status, audioFilePath=:filePath, duration=:duration WHERE id=:id")
    suspend fun updateRecordingData(id: Long, status: String, filePath: String, duration: Long)

    @Transaction
    @Query("SELECT * FROM calls ORDER BY timestamp DESC")
    suspend fun getAllCallsWithTranscripts(): List<CallWithTranscriptLocal>

    @Transaction
    @Query("SELECT * FROM calls WHERE id = :id LIMIT 1")
    suspend fun getCallWithTranscriptById(id: Long): CallWithTranscriptLocal?
}
