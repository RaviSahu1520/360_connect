package com.company.app.presentation.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/company/app/presentation/history/CallDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getCallDetailUseCase", "Lcom/company/app/domain/usecase/call/GetCallDetailUseCase;", "callScopedRagQueryUseCase", "Lcom/company/app/domain/usecase/ai/CallScopedRAGQueryUseCase;", "(Lcom/company/app/domain/usecase/call/GetCallDetailUseCase;Lcom/company/app/domain/usecase/ai/CallScopedRAGQueryUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/app/presentation/history/CallDetailUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "askAiAboutCall", "", "callId", "", "query", "", "load", "toHeader", "Lcom/company/app/presentation/history/CallHeaderUi;", "Lcom/company/app/domain/model/CallWithTranscript;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CallDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.call.GetCallDetailUseCase getCallDetailUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.ai.CallScopedRAGQueryUseCase callScopedRagQueryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.app.presentation.history.CallDetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.history.CallDetailUiState> uiState = null;
    
    @javax.inject.Inject()
    public CallDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.call.GetCallDetailUseCase getCallDetailUseCase, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.ai.CallScopedRAGQueryUseCase callScopedRagQueryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.history.CallDetailUiState> getUiState() {
        return null;
    }
    
    public final void load(long callId) {
    }
    
    public final void askAiAboutCall(long callId, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final com.company.app.presentation.history.CallHeaderUi toHeader(com.company.app.domain.model.CallWithTranscript $this$toHeader) {
        return null;
    }
}