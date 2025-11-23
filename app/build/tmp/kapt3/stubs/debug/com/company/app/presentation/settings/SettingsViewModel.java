package com.company.app.presentation.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/company/app/presentation/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "modelDownloadManager", "Lcom/company/app/data/ai/manager/ModelDownloadManager;", "permissionsManager", "Lcom/company/app/presentation/permissions/PermissionsManager;", "(Lcom/company/app/data/ai/manager/ModelDownloadManager;Lcom/company/app/presentation/permissions/PermissionsManager;)V", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "permissionState", "Lcom/company/app/presentation/permissions/PermissionChecklistState;", "getPermissionState", "downloadModels", "", "onPermissionResult", "type", "Lcom/company/app/presentation/permissions/PermissionType;", "granted", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.ai.manager.ModelDownloadManager modelDownloadManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.presentation.permissions.PermissionsManager permissionsManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionChecklistState> permissionState = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.data.ai.manager.ModelDownloadManager modelDownloadManager, @org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionsManager permissionsManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionChecklistState> getPermissionState() {
        return null;
    }
    
    public final void downloadModels() {
    }
    
    public final void onPermissionResult(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionType type, boolean granted) {
    }
}