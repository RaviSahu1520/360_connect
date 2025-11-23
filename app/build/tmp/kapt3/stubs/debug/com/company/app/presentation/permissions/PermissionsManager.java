package com.company.app.presentation.permissions;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/company/app/presentation/permissions/PermissionsManager;", "", "context", "Landroid/content/Context;", "audioCaptureManager", "Lcom/company/app/platform/recording/AudioCaptureManager;", "(Landroid/content/Context;Lcom/company/app/platform/recording/AudioCaptureManager;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/app/presentation/permissions/PermissionChecklistState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "accessibilityStatus", "Lcom/company/app/presentation/permissions/PermissionStatus;", "mark", "", "type", "Lcom/company/app/presentation/permissions/PermissionType;", "granted", "", "mediaProjectionStatus", "microphoneStatus", "notificationStatus", "overlayStatus", "permissionSnapshot", "", "refresh", "app_debug"})
public final class PermissionsManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.platform.recording.AudioCaptureManager audioCaptureManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.app.presentation.permissions.PermissionChecklistState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionChecklistState> state = null;
    
    @javax.inject.Inject()
    public PermissionsManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.app.platform.recording.AudioCaptureManager audioCaptureManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionChecklistState> getState() {
        return null;
    }
    
    public final void refresh() {
    }
    
    public final void mark(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionType type, boolean granted) {
    }
    
    private final java.util.Map<com.company.app.presentation.permissions.PermissionType, com.company.app.presentation.permissions.PermissionStatus> permissionSnapshot() {
        return null;
    }
    
    private final com.company.app.presentation.permissions.PermissionStatus microphoneStatus() {
        return null;
    }
    
    private final com.company.app.presentation.permissions.PermissionStatus overlayStatus() {
        return null;
    }
    
    private final com.company.app.presentation.permissions.PermissionStatus accessibilityStatus() {
        return null;
    }
    
    private final com.company.app.presentation.permissions.PermissionStatus notificationStatus() {
        return null;
    }
    
    private final com.company.app.presentation.permissions.PermissionStatus mediaProjectionStatus() {
        return null;
    }
}