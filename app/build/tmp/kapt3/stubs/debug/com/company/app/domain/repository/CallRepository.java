package com.company.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0015H&J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u0006\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0011H\u00a6@\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/company/app/domain/repository/CallRepository;", "", "createCallRecord", "", "callInfo", "Lcom/company/app/domain/model/CallInfo;", "(Lcom/company/app/domain/model/CallInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCallsWithTranscripts", "", "Lcom/company/app/domain/model/CallWithTranscript;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallWithTranscript", "callId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markCallCompleted", "", "filePath", "", "durationMillis", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeCalls", "Lkotlinx/coroutines/flow/Flow;", "Lcom/company/app/domain/model/Call;", "observeTranscript", "Lcom/company/app/domain/model/Transcript;", "startCall", "remoteUserId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CallRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.company.app.domain.model.Call>> observeCalls();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.company.app.domain.model.Transcript> observeTranscript(long callId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startCall(@org.jetbrains.annotations.NotNull()
    java.lang.String remoteUserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createCallRecord(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.CallInfo callInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markCallCompleted(long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, long durationMillis, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllCallsWithTranscripts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.CallWithTranscript>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCallWithTranscript(long callId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.domain.model.CallWithTranscript> $completion);
}