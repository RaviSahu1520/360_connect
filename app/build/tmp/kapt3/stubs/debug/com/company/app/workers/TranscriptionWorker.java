package com.company.app.workers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B3\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/company/app/workers/TranscriptionWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "whisperEngine", "Lcom/company/app/data/ai/engine/WhisperEngine;", "transcriptDao", "Lcom/company/app/data/local/dao/TranscriptDao;", "callDao", "Lcom/company/app/data/local/dao/CallDao;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/company/app/data/ai/engine/WhisperEngine;Lcom/company/app/data/local/dao/TranscriptDao;Lcom/company/app/data/local/dao/CallDao;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistTranscript", "", "callId", "text", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@androidx.hilt.work.HiltWorker()
public final class TranscriptionWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.ai.engine.WhisperEngine whisperEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.TranscriptDao transcriptDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.CallDao callDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "TranscriptionWorker";
    private static final int MAX_RETRIES = 3;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_AUDIO_PATH = "audio_file_path";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_CALL_ID = "call_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_TRANSCRIPT_ID = "transcript_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_TRANSCRIPT_TEXT = "transcript_text";
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.workers.TranscriptionWorker.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public TranscriptionWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.company.app.data.ai.engine.WhisperEngine whisperEngine, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.TranscriptDao transcriptDao, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.CallDao callDao) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    private final java.lang.Object persistTranscript(long callId, java.lang.String text, kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/company/app/workers/TranscriptionWorker$Companion;", "", "()V", "KEY_AUDIO_PATH", "", "KEY_CALL_ID", "KEY_TRANSCRIPT_ID", "KEY_TRANSCRIPT_TEXT", "MAX_RETRIES", "", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}