package com.company.app.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.company.app.data.local.entity.CallEntity
import com.company.app.data.local.entity.TranscriptEntity

data class CallWithTranscriptLocal(
    @Embedded val call: CallEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "callId"
    )
    val transcript: TranscriptEntity?
)
