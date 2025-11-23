package com.company.app.platform.recording;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010!R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/company/app/platform/recording/CallRecordingController;", "", "context", "Landroid/content/Context;", "callRepository", "Lcom/company/app/domain/repository/CallRepository;", "audioCaptureManager", "Lcom/company/app/platform/recording/AudioCaptureManager;", "dispatchers", "Lcom/company/app/core/common/DispatcherProvider;", "(Landroid/content/Context;Lcom/company/app/domain/repository/CallRepository;Lcom/company/app/platform/recording/AudioCaptureManager;Lcom/company/app/core/common/DispatcherProvider;)V", "activeCallId", "", "Ljava/lang/Long;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "outputFile", "Ljava/io/File;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "buildOutputFile", "callId", "isRecording", "", "provideMediaProjection", "", "projection", "Landroid/media/projection/MediaProjection;", "startRecording", "callInfo", "Lcom/company/app/domain/model/CallInfo;", "(Lcom/company/app/domain/model/CallInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CallRecordingController {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.repository.CallRepository callRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.platform.recording.AudioCaptureManager audioCaptureManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.common.DispatcherProvider dispatchers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex mutex = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long activeCallId;
    @org.jetbrains.annotations.Nullable()
    private java.io.File outputFile;
    
    @javax.inject.Inject()
    public CallRecordingController(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.CallRepository callRepository, @org.jetbrains.annotations.NotNull()
    com.company.app.platform.recording.AudioCaptureManager audioCaptureManager, @org.jetbrains.annotations.NotNull()
    com.company.app.core.common.DispatcherProvider dispatchers) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startRecording(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.CallInfo callInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object stopRecording(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final boolean isRecording() {
        return false;
    }
    
    public final void provideMediaProjection(@org.jetbrains.annotations.NotNull()
    android.media.projection.MediaProjection projection) {
    }
    
    private final java.io.File buildOutputFile(long callId) {
        return null;
    }
}