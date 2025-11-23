package com.company.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "transcripts",
    foreignKeys = [
        ForeignKey(
            entity = CallEntity::class,
            parentColumns = ["id"],
            childColumns = ["callId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TranscriptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val callId: Long,
    val fullText: String,
    val summary: String,
    val speakerMap: String,
    val timestamp: Long
)
