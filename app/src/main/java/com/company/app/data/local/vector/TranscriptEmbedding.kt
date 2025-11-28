package com.company.app.data.local.vector

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.company.app.data.local.entity.TranscriptEntity
import com.google.gson.Gson

@Entity(
    tableName = "embeddings",
    foreignKeys = [
        ForeignKey(
            entity = TranscriptEntity::class,
            parentColumns = ["id"],
            childColumns = ["transcriptId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("transcriptId")]
)
data class TranscriptEmbeddingEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val transcriptId: Long,
    val callId: Long,
    val textChunk: String,
    val embeddingJson: String,
    val timestamp: Long
)

class EmbeddingConverters {
    @TypeConverter
    fun fromFloatArray(value: FloatArray): String = Gson().toJson(value)

    @TypeConverter
    fun toFloatArray(value: String): FloatArray = Gson().fromJson(value, FloatArray::class.java)
}
