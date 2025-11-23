package com.company.app.platform.recording;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\"\u0010)\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u001fH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/company/app/platform/recording/CallRecordingService;", "Landroid/app/Service;", "()V", "audioCaptureManager", "Lcom/company/app/platform/recording/AudioCaptureManager;", "getAudioCaptureManager", "()Lcom/company/app/platform/recording/AudioCaptureManager;", "setAudioCaptureManager", "(Lcom/company/app/platform/recording/AudioCaptureManager;)V", "callId", "", "callRepository", "Lcom/company/app/domain/repository/CallRepository;", "getCallRepository", "()Lcom/company/app/domain/repository/CallRepository;", "setCallRepository", "(Lcom/company/app/domain/repository/CallRepository;)V", "dispatchers", "Lcom/company/app/core/common/DispatcherProvider;", "getDispatchers", "()Lcom/company/app/core/common/DispatcherProvider;", "setDispatchers", "(Lcom/company/app/core/common/DispatcherProvider;)V", "outputPath", "", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "startedAt", "buildNotification", "Landroid/app/Notification;", "enqueueWorkers", "", "audioPath", "ensureNotificationChannel", "handleStart", "intent", "Landroid/content/Intent;", "handleStop", "onBind", "Landroid/os/IBinder;", "onCreate", "onStartCommand", "", "flags", "startId", "startForegroundWithType", "Companion", "app_debug"})
public final class CallRecordingService extends android.app.Service {
    @javax.inject.Inject()
    public com.company.app.platform.recording.AudioCaptureManager audioCaptureManager;
    @javax.inject.Inject()
    public com.company.app.domain.repository.CallRepository callRepository;
    @javax.inject.Inject()
    public com.company.app.core.common.DispatcherProvider dispatchers;
    private kotlinx.coroutines.CoroutineScope serviceScope;
    private long callId = -1L;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String outputPath;
    private long startedAt = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_START = "call_recording_start";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP = "call_recording_stop";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CALL_ID = "extra_call_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_OUTPUT_PATH = "extra_output_path";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_ID = "call_recording_channel";
    private static final int NOTIFICATION_ID = 1330;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.platform.recording.CallRecordingService.Companion Companion = null;
    
    public CallRecordingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.platform.recording.AudioCaptureManager getAudioCaptureManager() {
        return null;
    }
    
    public final void setAudioCaptureManager(@org.jetbrains.annotations.NotNull()
    com.company.app.platform.recording.AudioCaptureManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.repository.CallRepository getCallRepository() {
        return null;
    }
    
    public final void setCallRepository(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.CallRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.core.common.DispatcherProvider getDispatchers() {
        return null;
    }
    
    public final void setDispatchers(@org.jetbrains.annotations.NotNull()
    com.company.app.core.common.DispatcherProvider p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void handleStart(android.content.Intent intent) {
    }
    
    private final void handleStop(android.content.Intent intent) {
    }
    
    private final void enqueueWorkers(long callId, java.lang.String audioPath) {
    }
    
    private final void ensureNotificationChannel() {
    }
    
    private final android.app.Notification buildNotification() {
        return null;
    }
    
    private final void startForegroundWithType() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/company/app/platform/recording/CallRecordingService$Companion;", "", "()V", "ACTION_START", "", "ACTION_STOP", "CHANNEL_ID", "EXTRA_CALL_ID", "EXTRA_OUTPUT_PATH", "NOTIFICATION_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}