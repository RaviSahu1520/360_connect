package com.company.app.platform.recording;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u0018R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/company/app/platform/recording/AudioCaptureManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioRecord", "Landroid/media/AudioRecord;", "capturing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "codec", "Landroid/media/MediaCodec;", "mediaProjection", "Landroid/media/projection/MediaProjection;", "muxer", "Landroid/media/MediaMuxer;", "projectionCallback", "Landroid/media/projection/MediaProjection$Callback;", "recordingJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "trackIndex", "", "captureInternal", "", "outputFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drainEncoder", "encoder", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "hasProjection", "", "isCapturing", "queueAudio", "record", "releaseResources", "requestProjectionIntent", "Landroid/content/Intent;", "setMediaProjection", "projection", "startCapture", "stopCapture", "Companion", "app_debug"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
public final class AudioCaptureManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean capturing = null;
    @org.jetbrains.annotations.Nullable()
    private android.media.projection.MediaProjection mediaProjection;
    @org.jetbrains.annotations.Nullable()
    private android.media.AudioRecord audioRecord;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaCodec codec;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaMuxer muxer;
    private int trackIndex = -1;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job recordingJob;
    @org.jetbrains.annotations.NotNull()
    private final android.media.projection.MediaProjection.Callback projectionCallback = null;
    private static final int SAMPLE_RATE = 44100;
    private static final int BIT_RATE = 128000;
    private static final long DEQUEUE_TIMEOUT_US = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.platform.recording.AudioCaptureManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public AudioCaptureManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent requestProjectionIntent() {
        return null;
    }
    
    public final void setMediaProjection(@org.jetbrains.annotations.NotNull()
    android.media.projection.MediaProjection projection) {
    }
    
    public final boolean hasProjection() {
        return false;
    }
    
    public final void startCapture(@org.jetbrains.annotations.NotNull()
    java.io.File outputFile) {
    }
    
    public final void stopCapture() {
    }
    
    public final boolean isCapturing() {
        return false;
    }
    
    private final java.lang.Object captureInternal(java.io.File outputFile, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void queueAudio(android.media.AudioRecord record, android.media.MediaCodec encoder) {
    }
    
    private final void drainEncoder(android.media.MediaCodec encoder, android.media.MediaCodec.BufferInfo bufferInfo) {
    }
    
    private final void releaseResources() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/company/app/platform/recording/AudioCaptureManager$Companion;", "", "()V", "BIT_RATE", "", "DEQUEUE_TIMEOUT_US", "", "SAMPLE_RATE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}