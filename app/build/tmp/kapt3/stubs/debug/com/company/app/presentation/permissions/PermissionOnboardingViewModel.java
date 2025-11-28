package com.company.app.presentation.permissions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/company/app/presentation/permissions/PermissionOnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "permissionsManager", "Lcom/company/app/presentation/permissions/PermissionsManager;", "(Lcom/company/app/presentation/permissions/PermissionsManager;)V", "_commands", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/company/app/presentation/permissions/PermissionCommand;", "commands", "Lkotlinx/coroutines/flow/SharedFlow;", "getCommands", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "definitions", "", "Lcom/company/app/presentation/permissions/PermissionStepDefinition;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/company/app/presentation/permissions/PermissionOnboardingUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "moveNext", "", "movePrevious", "onGrantClicked", "onPermissionResult", "type", "Lcom/company/app/presentation/permissions/PermissionType;", "granted", "", "requestPermission", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PermissionOnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.presentation.permissions.PermissionsManager permissionsManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> currentIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.company.app.presentation.permissions.PermissionCommand> _commands = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.company.app.presentation.permissions.PermissionCommand> commands = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.company.app.presentation.permissions.PermissionStepDefinition> definitions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionOnboardingUiState> uiState = null;
    
    @javax.inject.Inject()
    public PermissionOnboardingViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionsManager permissionsManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.company.app.presentation.permissions.PermissionCommand> getCommands() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.permissions.PermissionOnboardingUiState> getUiState() {
        return null;
    }
    
    public final void onGrantClicked() {
    }
    
    public final void requestPermission(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionType type) {
    }
    
    public final void onPermissionResult(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionType type, boolean granted) {
    }
    
    public final void moveNext() {
    }
    
    public final void movePrevious() {
    }
}