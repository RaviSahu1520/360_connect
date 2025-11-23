package com.company.app.presentation.chat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/company/app/presentation/chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "observeChatMessagesUseCase", "Lcom/company/app/domain/usecase/chat/ObserveChatMessagesUseCase;", "sendMessageUseCase", "Lcom/company/app/domain/usecase/chat/SendMessageUseCase;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/company/app/domain/usecase/chat/ObserveChatMessagesUseCase;Lcom/company/app/domain/usecase/chat/SendMessageUseCase;)V", "chatId", "", "inputFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/company/app/presentation/chat/ChatUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onMessageChanged", "", "value", "onSendClicked", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.usecase.chat.SendMessageUseCase sendMessageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String chatId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> inputFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.chat.ChatUiState> uiState = null;
    
    @javax.inject.Inject()
    public ChatViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.chat.ObserveChatMessagesUseCase observeChatMessagesUseCase, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.usecase.chat.SendMessageUseCase sendMessageUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.app.presentation.chat.ChatUiState> getUiState() {
        return null;
    }
    
    public final void onMessageChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onSendClicked() {
    }
}