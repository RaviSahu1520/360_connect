package com.company.app.presentation.permissions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001aD\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a(\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\f\u001a\u00020\rH\u0003\u001aF\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010!0 0\u001fH\u0002\u00a8\u0006\""}, d2 = {"MainScreen", "", "audioCaptureManager", "Lcom/company/app/platform/recording/AudioCaptureManager;", "onAllPermissionsGranted", "Lkotlin/Function0;", "PermissionOnboardingScreen", "state", "Lcom/company/app/presentation/permissions/PermissionOnboardingUiState;", "onGrant", "onNext", "onPrevious", "modifier", "Landroidx/compose/ui/Modifier;", "PermissionStatusChip", "status", "Lcom/company/app/presentation/permissions/PermissionStatus;", "StepIndicator", "steps", "", "Lcom/company/app/presentation/permissions/PermissionStepUi;", "currentIndex", "", "handlePermissionResult", "type", "Lcom/company/app/presentation/permissions/PermissionType;", "granted", "", "viewModel", "Lcom/company/app/presentation/permissions/PermissionOnboardingViewModel;", "callbacks", "", "", "Lkotlin/Function1;", "app_debug"})
public final class PermissionOnboardingScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void PermissionOnboardingScreen(@org.jetbrains.annotations.NotNull()
    com.company.app.presentation.permissions.PermissionOnboardingUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onGrant, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPrevious, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StepIndicator(java.util.List<com.company.app.presentation.permissions.PermissionStepUi> steps, int currentIndex, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PermissionStatusChip(com.company.app.presentation.permissions.PermissionStatus status) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreen(@org.jetbrains.annotations.NotNull()
    com.company.app.platform.recording.AudioCaptureManager audioCaptureManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAllPermissionsGranted) {
    }
    
    private static final void handlePermissionResult(com.company.app.presentation.permissions.PermissionType type, boolean granted, com.company.app.presentation.permissions.PermissionOnboardingViewModel viewModel, java.util.Map<com.company.app.presentation.permissions.PermissionType, java.util.List<kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>>> callbacks) {
    }
}