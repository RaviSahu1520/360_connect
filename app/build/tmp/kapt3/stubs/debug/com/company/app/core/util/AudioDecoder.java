package com.company.app.core.util;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/company/app/core/util/AudioDecoder;", "", "()V", "decodeToFloatFile", "", "inputFile", "Ljava/io/File;", "outputFile", "targetSampleRate", "(Ljava/io/File;Ljava/io/File;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downmix", "", "data", "channels", "resample", "", "sourceRate", "targetRate", "selectAudioTrack", "extractor", "Landroid/media/MediaExtractor;", "toFloat", "shorts", "Companion", "app_debug"})
public final class AudioDecoder {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AudioDecoder";
    private static final long TIMEOUT_US = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.core.util.AudioDecoder.Companion Companion = null;
    
    @javax.inject.Inject()
    public AudioDecoder() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object decodeToFloatFile(@org.jetbrains.annotations.NotNull()
    java.io.File inputFile, @org.jetbrains.annotations.NotNull()
    java.io.File outputFile, int targetSampleRate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final int selectAudioTrack(android.media.MediaExtractor extractor) {
        return 0;
    }
    
    private final float[] toFloat(short[] shorts) {
        return null;
    }
    
    private final short[] downmix(short[] data, int channels) {
        return null;
    }
    
    private final float[] resample(float[] data, int sourceRate, int targetRate) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/company/app/core/util/AudioDecoder$Companion;", "", "()V", "TAG", "", "TIMEOUT_US", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}