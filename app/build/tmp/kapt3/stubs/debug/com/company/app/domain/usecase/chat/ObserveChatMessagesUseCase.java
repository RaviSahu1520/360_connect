package com.company.app.domain.usecase.chat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/company/app/domain/usecase/chat/ObserveChatMessagesUseCase;", "", "repository", "Lcom/company/app/domain/repository/ChatRepository;", "(Lcom/company/app/domain/repository/ChatRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/company/app/domain/model/Message;", "chatId", "", "app_debug"})
public final class ObserveChatMessagesUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.repository.ChatRepository repository = null;
    
    @javax.inject.Inject()
    public ObserveChatMessagesUseCase(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.ChatRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.company.app.domain.model.Message>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId) {
        return null;
    }
}