package com.company.app.data.local.vector;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ8\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/company/app/data/local/vector/VectorStore;", "", "findNearestForCall", "", "Lcom/company/app/domain/model/TranscriptChunk;", "callId", "", "queryEmbedding", "", "limit", "", "(J[FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChunk", "transcriptId", "text", "", "embedding", "timestamp", "(JJLjava/lang/String;[FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "([FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface VectorStore {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertChunk(long transcriptId, long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    float[] embedding, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.domain.model.TranscriptChunk> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findNearestForCall(long callId, @org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}