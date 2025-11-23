package com.company.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00110\u001eH\u0016J\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u001e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0016\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/company/app/data/repository/CallRepositoryImpl;", "Lcom/company/app/domain/repository/CallRepository;", "callDao", "Lcom/company/app/data/local/dao/CallDao;", "transcriptDao", "Lcom/company/app/data/local/dao/TranscriptDao;", "encryptionManager", "Lcom/company/app/core/security/EncryptionManager;", "dispatchers", "Lcom/company/app/core/common/DispatcherProvider;", "(Lcom/company/app/data/local/dao/CallDao;Lcom/company/app/data/local/dao/TranscriptDao;Lcom/company/app/core/security/EncryptionManager;Lcom/company/app/core/common/DispatcherProvider;)V", "createCallRecord", "", "callInfo", "Lcom/company/app/domain/model/CallInfo;", "(Lcom/company/app/domain/model/CallInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCallsWithTranscripts", "", "Lcom/company/app/domain/model/CallWithTranscript;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallWithTranscript", "callId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markCallCompleted", "", "filePath", "", "durationMillis", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeCalls", "Lkotlinx/coroutines/flow/Flow;", "Lcom/company/app/domain/model/Call;", "observeTranscript", "Lcom/company/app/domain/model/Transcript;", "startCall", "remoteUserId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CallRepositoryImpl implements com.company.app.domain.repository.CallRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.CallDao callDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.TranscriptDao transcriptDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.security.EncryptionManager encryptionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.common.DispatcherProvider dispatchers = null;
    
    @javax.inject.Inject()
    public CallRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.CallDao callDao, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.TranscriptDao transcriptDao, @org.jetbrains.annotations.NotNull()
    com.company.app.core.security.EncryptionManager encryptionManager, @org.jetbrains.annotations.NotNull()
    com.company.app.core.common.DispatcherProvider dispatchers) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.company.app.domain.model.Call>> observeCalls() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.company.app.domain.model.Transcript> observeTranscript(long callId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object startCall(@org.jetbrains.annotations.NotNull()
    java.lang.String remoteUserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createCallRecord(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.CallInfo callInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object markCallCompleted(long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, long durationMillis, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllCallsWithTranscripts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.CallWithTranscript>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCallWithTranscript(long callId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.domain.model.CallWithTranscript> $completion) {
        return null;
    }
}