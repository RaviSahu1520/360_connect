package com.company.app.presentation.ai;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/company/app/presentation/ai/AskAiViewModel;", "Landroidx/lifecycle/ViewModel;", "ragQueryUseCase", "Lcom/company/app/domain/usecase/ai/RagQueryUseCase;", "(Lcom/company/app/domain/usecase/ai/RagQueryUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/app/presentation/ai/AskAiUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onQueryChange", "", "new", "", "submitQuery", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AskAiViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.ai.RagQueryUseCase ragQueryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.app.presentation.ai.AskAiUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.ai.AskAiUiState> uiState = null;
    
    @javax.inject.Inject()
    public AskAiViewModel(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.ai.RagQueryUseCase ragQueryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.ai.AskAiUiState> getUiState() {
        return null;
    }
    
    public final void onQueryChange(@org.jetbrains.annotations.NotNull()
    java.lang.String p0_54480) {
    }
    
    public final void submitQuery() {
    }
}