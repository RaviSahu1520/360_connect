package com.company.app.data.local.vector;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J6\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u001bJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010\"\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/company/app/data/local/vector/RoomVectorStore;", "Lcom/company/app/data/local/vector/VectorStore;", "embeddingDao", "Lcom/company/app/data/local/dao/EmbeddingDao;", "converters", "Lcom/company/app/data/local/vector/EmbeddingConverters;", "(Lcom/company/app/data/local/dao/EmbeddingDao;Lcom/company/app/data/local/vector/EmbeddingConverters;)V", "cosineSimilarity", "", "first", "", "second", "findNearestForCall", "", "Lcom/company/app/domain/model/TranscriptChunk;", "callId", "", "queryEmbedding", "limit", "", "(J[FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChunk", "transcriptId", "text", "", "embedding", "timestamp", "(JJLjava/lang/String;[FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rankEmbeddings", "entities", "Lcom/company/app/data/local/vector/TranscriptEmbeddingEntity;", "search", "([FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomainChunk", "vec", "app_debug"})
public final class RoomVectorStore implements com.company.app.data.local.vector.VectorStore {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.EmbeddingDao embeddingDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.vector.EmbeddingConverters converters = null;
    
    @javax.inject.Inject()
    public RoomVectorStore(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.EmbeddingDao embeddingDao, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.vector.EmbeddingConverters converters) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertChunk(long transcriptId, long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    float[] embedding, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.domain.model.TranscriptChunk> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object search(@org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object findNearestForCall(long callId, @org.jetbrains.annotations.NotNull()
    float[] queryEmbedding, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion) {
        return null;
    }
    
    private final java.util.List<com.company.app.domain.model.TranscriptChunk> rankEmbeddings(java.util.List<com.company.app.data.local.vector.TranscriptEmbeddingEntity> entities, float[] queryEmbedding, int limit) {
        return null;
    }
    
    private final com.company.app.domain.model.TranscriptChunk toDomainChunk(com.company.app.data.local.vector.TranscriptEmbeddingEntity $this$toDomainChunk, float[] vec) {
        return null;
    }
    
    private final float cosineSimilarity(float[] first, float[] second) {
        return 0.0F;
    }
}