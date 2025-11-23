package com.company.app.data.local.vector;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\f\u0010\u001d\u001a\u00020\u000f*\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/company/app/data/local/vector/InMemoryVectorStore;", "Lcom/company/app/data/local/vector/VectorStore;", "()V", "idGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "items", "", "Lcom/company/app/data/local/vector/TranscriptEmbedding;", "cosineSimilarity", "", "first", "", "second", "findNearestForCall", "", "Lcom/company/app/domain/model/TranscriptChunk;", "callId", "", "queryEmbedding", "limit", "", "(J[FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChunk", "transcriptId", "text", "", "embedding", "timestamp", "search", "toDomainChunk", "app_debug"})
public final class InMemoryVectorStore implements com.company.app.data.local.vector.VectorStore {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.company.app.data.local.vector.TranscriptEmbedding> items = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicLong idGenerator = null;
    
    public InMemoryVectorStore() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.company.app.domain.model.TranscriptChunk insertChunk(long transcriptId, long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    float[] embedding, long timestamp) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.company.app.domain.model.TranscriptChunk> search(@org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object findNearestForCall(long callId, @org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion) {
        return null;
    }
    
    private final com.company.app.domain.model.TranscriptChunk toDomainChunk(com.company.app.data.local.vector.TranscriptEmbedding $this$toDomainChunk) {
        return null;
    }
    
    private final float cosineSimilarity(float[] first, float[] second) {
        return 0.0F;
    }
}