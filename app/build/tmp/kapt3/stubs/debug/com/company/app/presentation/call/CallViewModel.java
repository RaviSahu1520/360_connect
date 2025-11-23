package com.company.app.presentation.call;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/company/app/presentation/call/CallViewModel;", "Landroidx/lifecycle/ViewModel;", "voipClient", "Lcom/company/app/platform/call/VoipClient;", "startRecordingUseCase", "Lcom/company/app/domain/usecase/call/StartRecordingUseCase;", "stopRecordingUseCase", "Lcom/company/app/domain/usecase/call/StopRecordingUseCase;", "transcribeCallUseCase", "Lcom/company/app/domain/usecase/ai/TranscribeCallUseCase;", "ragQueryUseCase", "Lcom/company/app/domain/usecase/ai/RagQueryUseCase;", "(Lcom/company/app/platform/call/VoipClient;Lcom/company/app/domain/usecase/call/StartRecordingUseCase;Lcom/company/app/domain/usecase/call/StopRecordingUseCase;Lcom/company/app/domain/usecase/ai/TranscribeCallUseCase;Lcom/company/app/domain/usecase/ai/RagQueryUseCase;)V", "ragAnswer", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "ragError", "transcription", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/company/app/presentation/call/CallUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "endCall", "", "queryRag", "prompt", "startCall", "remoteUserId", "toggleMute", "transcribe", "audioPath", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CallViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.platform.call.VoipClient voipClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.call.StartRecordingUseCase startRecordingUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.call.StopRecordingUseCase stopRecordingUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.ai.TranscribeCallUseCase transcribeCallUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.ai.RagQueryUseCase ragQueryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> transcription = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> ragAnswer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> ragError = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.call.CallUiState> uiState = null;
    
    @javax.inject.Inject()
    public CallViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.platform.call.VoipClient voipClient, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.call.StartRecordingUseCase startRecordingUseCase, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.call.StopRecordingUseCase stopRecordingUseCase, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.ai.TranscribeCallUseCase transcribeCallUseCase, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.ai.RagQueryUseCase ragQueryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.call.CallUiState> getUiState() {
        return null;
    }
    
    public final void startCall(@org.jetbrains.annotations.NotNull()
    java.lang.String remoteUserId) {
    }
    
    public final void endCall() {
    }
    
    public final void toggleMute() {
    }
    
    public final void transcribe(@org.jetbrains.annotations.NotNull()
    java.lang.String audioPath) {
    }
    
    public final void queryRag(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt) {
    }
}