package com.company.app.workers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B3\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/company/app/workers/EmbeddingWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "embedder", "Lcom/company/app/data/ai/engine/TFLiteEmbedder;", "vectorStore", "Lcom/company/app/data/local/vector/VectorStore;", "transcriptDao", "Lcom/company/app/data/local/dao/TranscriptDao;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/company/app/data/ai/engine/TFLiteEmbedder;Lcom/company/app/data/local/vector/VectorStore;Lcom/company/app/data/local/dao/TranscriptDao;)V", "chunkTranscript", "", "", "text", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@androidx.hilt.work.HiltWorker()
public final class EmbeddingWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.ai.engine.TFLiteEmbedder embedder = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.vector.VectorStore vectorStore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.TranscriptDao transcriptDao = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EmbeddingWorker";
    private static final int MAX_RETRIES = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.workers.EmbeddingWorker.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public EmbeddingWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.company.app.data.ai.engine.TFLiteEmbedder embedder, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.vector.VectorStore vectorStore, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.TranscriptDao transcriptDao) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    private final java.util.List<java.lang.String> chunkTranscript(java.lang.String text) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/company/app/workers/EmbeddingWorker$Companion;", "", "()V", "MAX_RETRIES", "", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}