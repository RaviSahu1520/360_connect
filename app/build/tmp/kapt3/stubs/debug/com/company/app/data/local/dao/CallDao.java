package com.company.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u000fH\'J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/company/app/data/local/dao/CallDao;", "", "getAllCallsWithTranscripts", "", "Lcom/company/app/data/local/model/CallWithTranscriptLocal;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallWithTranscriptById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "call", "Lcom/company/app/data/local/entity/CallEntity;", "(Lcom/company/app/data/local/entity/CallEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeCalls", "Lkotlinx/coroutines/flow/Flow;", "updateRecordingData", "", "status", "", "filePath", "duration", "(JLjava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatus", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "app_debug"})
@androidx.room.Dao()
public abstract interface CallDao {
    
    @androidx.room.Query(value = "SELECT * FROM calls ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.company.app.data.local.entity.CallEntity>> observeCalls();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.entity.CallEntity call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.entity.CallEntity call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "UPDATE calls SET transcriptionStatus=:status WHERE id=:id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStatus(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE calls SET transcriptionStatus=:status, audioFilePath=:filePath, duration=:duration WHERE id=:id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRecordingData(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, long duration, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM calls ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllCallsWithTranscripts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.data.local.model.CallWithTranscriptLocal>> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM calls WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCallWithTranscriptById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.data.local.model.CallWithTranscriptLocal> $completion);
}