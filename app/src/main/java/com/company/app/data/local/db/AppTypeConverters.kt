package com.company.app.data.local.db

import androidx.room.TypeConverter
import com.company.app.domain.model.CallType
import com.company.app.domain.model.TranscriptionStatus
import kotlinx.datetime.Instant

class AppTypeConverters {
    @TypeConverter
    fun toCallType(value: String): CallType = CallType.valueOf(value)

    @TypeConverter
    fun fromCallType(type: CallType): String = type.name

    @TypeConverter
    fun toTranscriptionStatus(value: String): TranscriptionStatus = TranscriptionStatus.valueOf(value)

    @TypeConverter
    fun fromTranscriptionStatus(status: TranscriptionStatus): String = status.name

    @TypeConverter
    fun toInstant(epochMillis: Long): Instant = Instant.fromEpochMilliseconds(epochMillis)

    @TypeConverter
    fun fromInstant(instant: Instant): Long = instant.toEpochMilliseconds()
}
