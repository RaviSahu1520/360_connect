package com.company.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.company.app.domain.model.CallType
import com.company.app.domain.model.TranscriptionStatus

@Entity(tableName = "calls")
data class CallEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val remoteUserId: String,
    val source: String,
    val type: CallType,
    val timestamp: Long,
    val duration: Long,
    val audioFilePath: String,
    val transcriptionStatus: TranscriptionStatus
)
