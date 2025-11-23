package com.company.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r2\u0006\u0010\u0004\u001a\u00020\u0005H\'J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/company/app/data/local/dao/TranscriptDao;", "", "findByCallId", "Lcom/company/app/data/local/entity/TranscriptEntity;", "callId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "id", "insert", "transcript", "(Lcom/company/app/data/local/entity/TranscriptEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTranscript", "Lkotlinx/coroutines/flow/Flow;", "updateSummary", "", "summary", "", "timestamp", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTranscript", "text", "upsert", "app_debug"})
@androidx.room.Dao()
public abstract interface TranscriptDao {
    
    @androidx.room.Query(value = "SELECT * FROM transcripts WHERE callId = :callId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.company.app.data.local.entity.TranscriptEntity> observeTranscript(long callId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.entity.TranscriptEntity transcript, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.entity.TranscriptEntity transcript, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transcripts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.data.local.entity.TranscriptEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transcripts WHERE callId = :callId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByCallId(long callId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.data.local.entity.TranscriptEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE transcripts SET summary=:summary, timestamp=:timestamp WHERE id=:id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSummary(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String summary, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE transcripts SET fullText=:text, timestamp=:timestamp WHERE id=:id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTranscript(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String text, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}