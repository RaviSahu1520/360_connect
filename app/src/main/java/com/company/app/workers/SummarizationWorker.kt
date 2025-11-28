package com.company.app.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.company.app.data.local.dao.TranscriptDao
import com.company.app.data.remote.llm.LLMEngine
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SummarizationWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val llmEngine: LLMEngine,
    private val transcriptDao: TranscriptDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val callId = inputData.getLong(TranscriptionWorker.KEY_CALL_ID, -1L)
        if (callId <= 0) return Result.failure()
        val transcriptId = inputData.getLong(TranscriptionWorker.KEY_TRANSCRIPT_ID, -1L)
        val transcript = if (transcriptId > 0) {
            transcriptDao.getById(transcriptId)
        } else {
            transcriptDao.findByCallId(callId)
        } ?: return Result.failure()

        return runCatching {
            val prompt = "Summarize this text briefly and clearly:\n${transcript.fullText}"
            val summary = llmEngine.generateResponse(prompt)
            transcriptDao.updateSummary(transcript.id, summary, System.currentTimeMillis())
            Log.d(TAG, "Summary generated for transcript=${transcript.id}")
            Result.success(
                workDataOf(
                    TranscriptionWorker.KEY_CALL_ID to callId,
                    TranscriptionWorker.KEY_TRANSCRIPT_ID to transcript.id,
                    KEY_SUMMARY to summary
                )
            )
        }.getOrElse {
            Log.e(TAG, "Summarization failed", it)
            if (runAttemptCount < MAX_RETRIES) Result.retry() else Result.failure()
        }
    }

    companion object {
        private const val TAG = "SummarizationWorker"
        private const val MAX_RETRIES = 2
        const val KEY_SUMMARY = "summary"
    }
}
