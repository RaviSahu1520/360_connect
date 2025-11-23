package com.company.app.platform.call;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/company/app/platform/call/CallSimulator;", "", "callRecordingController", "Lcom/company/app/platform/recording/CallRecordingController;", "(Lcom/company/app/platform/recording/CallRecordingController;)V", "simulateCallEnd", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "simulateIncomingCall", "number", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CallSimulator {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.platform.recording.CallRecordingController callRecordingController = null;
    
    @javax.inject.Inject()
    public CallSimulator(@org.jetbrains.annotations.NotNull()
    com.company.app.platform.recording.CallRecordingController callRecordingController) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object simulateIncomingCall(@org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object simulateCallEnd(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}