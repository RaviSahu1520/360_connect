package com.company.app.platform.call;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/company/app/platform/call/VoipSignalingService;", "Landroid/app/Service;", "()V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "signalingClient", "Lcom/company/app/data/remote/SignalingClient;", "getSignalingClient", "()Lcom/company/app/data/remote/SignalingClient;", "setSignalingClient", "(Lcom/company/app/data/remote/SignalingClient;)V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "app_debug"})
public final class VoipSignalingService extends android.app.Service {
    @javax.inject.Inject()
    public com.company.app.data.remote.SignalingClient signalingClient;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    
    public VoipSignalingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.remote.SignalingClient getSignalingClient() {
        return null;
    }
    
    public final void setSignalingClient(@org.jetbrains.annotations.NotNull()
    com.company.app.data.remote.SignalingClient p0) {
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
    public void onDestroy() {
    }
}