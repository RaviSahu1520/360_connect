package com.company.app.data.ai.engine;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0011\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0010H\u0082 J\u0011\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0082 J\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001bH\u0082 J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/company/app/data/ai/engine/WhisperEngine;", "", "context", "Landroid/content/Context;", "dispatchers", "Lcom/company/app/core/common/DispatcherProvider;", "assetExtractor", "Lcom/company/app/core/util/AssetExtractor;", "audioDecoder", "Lcom/company/app/core/util/AudioDecoder;", "(Landroid/content/Context;Lcom/company/app/core/common/DispatcherProvider;Lcom/company/app/core/util/AssetExtractor;Lcom/company/app/core/util/AudioDecoder;)V", "handle", "Ljava/util/concurrent/atomic/AtomicLong;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "benchmark", "", "audioFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInitialized", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeNative", "freeWhisper", "initWhisper", "modelPath", "", "transcribe", "audioPath", "transcribeNative", "Companion", "app_debug"})
public final class WhisperEngine {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.common.DispatcherProvider dispatchers = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.util.AssetExtractor assetExtractor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.util.AudioDecoder audioDecoder = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicLong handle = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex mutex = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "WhisperEngine";
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.data.ai.engine.WhisperEngine.Companion Companion = null;
    
    @javax.inject.Inject()
    public WhisperEngine(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.app.core.common.DispatcherProvider dispatchers, @org.jetbrains.annotations.NotNull()
    com.company.app.core.util.AssetExtractor assetExtractor, @org.jetbrains.annotations.NotNull()
    com.company.app.core.util.AudioDecoder audioDecoder) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object transcribe(@org.jetbrains.annotations.NotNull()
    java.io.File audioFile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object benchmark(@org.jetbrains.annotations.NotNull()
    java.io.File audioFile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    private final java.lang.Object ensureInitialized(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void freeNative() {
    }
    
    private final native long initWhisper(java.lang.String modelPath) {
        return 0L;
    }
    
    private final native java.lang.String transcribe(long handle, java.lang.String audioPath) {
        return null;
    }
    
    private final native void freeWhisper(long handle) {
    }
    
    private final java.lang.String transcribeNative(long handle, java.lang.String audioPath) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/company/app/data/ai/engine/WhisperEngine$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}