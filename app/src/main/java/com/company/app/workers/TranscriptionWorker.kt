package com.company.app.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.company.app.data.ai.engine.WhisperEngine
import com.company.app.data.local.dao.CallDao
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.local.entity.TranscriptEntity
import com.company.app.domain.model.TranscriptionStatus
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.io.File

@HiltWorker
class TranscriptionWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val whisperEngine: WhisperEngine,
    private val transcriptDao: TranscriptDao,
    private val callDao: CallDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val audioPath = inputData.getString(KEY_AUDIO_PATH) ?: return Result.failure()
        val callId = inputData.getLong(KEY_CALL_ID, -1L)
        if (callId <= 0) return Result.failure()
        return runCatching {
            val transcription = whisperEngine.transcribe(File(audioPath))
            val transcriptId = persistTranscript(callId, transcription)
            callDao.updateStatus(callId, TranscriptionStatus.COMPLETED.name)
            Log.d(TAG, "Transcription done for call=$callId id=$transcriptId")
            Result.success(
                workDataOf(
                    KEY_CALL_ID to callId,
                    KEY_AUDIO_PATH to audioPath,
                    KEY_TRANSCRIPT_ID to transcriptId,
                    KEY_TRANSCRIPT_TEXT to transcription
                )
            )
        }.getOrElse {
            Log.e(TAG, "Transcription failed", it)
            callDao.updateStatus(callId, TranscriptionStatus.FAILED.name)
            if (runAttemptCount < MAX_RETRIES) Result.retry() else Result.failure()
        }
    }

    private suspend fun persistTranscript(callId: Long, text: String): Long {
        val existing = transcriptDao.findByCallId(callId)
        return if (existing != null) {
            transcriptDao.updateTranscript(existing.id, text, System.currentTimeMillis())
            existing.id
        } else {
            transcriptDao.insert(
                TranscriptEntity(
                    callId = callId,
                    fullText = text,
                    summary = "",
                    speakerMap = "{}",
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }

    companion object {
        private const val TAG = "TranscriptionWorker"
        private const val MAX_RETRIES = 3
        const val KEY_AUDIO_PATH = "audio_file_path"
        const val KEY_CALL_ID = "call_id"
        const val KEY_TRANSCRIPT_ID = "transcript_id"
        const val KEY_TRANSCRIPT_TEXT = "transcript_text"
    }
}
