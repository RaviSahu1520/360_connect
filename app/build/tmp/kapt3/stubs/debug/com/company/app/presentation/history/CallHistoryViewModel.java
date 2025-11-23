package com.company.app.presentation.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/company/app/presentation/history/CallHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "getCallHistoryUseCase", "Lcom/company/app/domain/usecase/call/GetCallHistoryUseCase;", "(Lcom/company/app/domain/usecase/call/GetCallHistoryUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/app/presentation/history/CallHistoryUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHistory", "", "label", "", "Lcom/company/app/domain/model/CallType;", "toUi", "Lcom/company/app/presentation/history/CallHistoryItemUi;", "Lcom/company/app/domain/model/CallWithTranscript;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CallHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.call.GetCallHistoryUseCase getCallHistoryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.app.presentation.history.CallHistoryUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.history.CallHistoryUiState> uiState = null;
    
    @javax.inject.Inject()
    public CallHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.call.GetCallHistoryUseCase getCallHistoryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.history.CallHistoryUiState> getUiState() {
        return null;
    }
    
    public final void loadHistory() {
    }
    
    private final com.company.app.presentation.history.CallHistoryItemUi toUi(com.company.app.domain.model.CallWithTranscript $this$toUi) {
        return null;
    }
    
    private final java.lang.String label(com.company.app.domain.model.CallType $this$label) {
        return null;
    }
}