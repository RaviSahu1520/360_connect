package com.company.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/company/app/data/repository/ChatRepositoryImpl;", "Lcom/company/app/domain/repository/ChatRepository;", "messageDao", "Lcom/company/app/data/local/dao/MessageDao;", "encryptionManager", "Lcom/company/app/core/security/EncryptionManager;", "dispatchers", "Lcom/company/app/core/common/DispatcherProvider;", "(Lcom/company/app/data/local/dao/MessageDao;Lcom/company/app/core/security/EncryptionManager;Lcom/company/app/core/common/DispatcherProvider;)V", "localUserId", "", "observeMessages", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/company/app/domain/model/Message;", "chatId", "sendMessage", "", "content", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ChatRepositoryImpl implements com.company.app.domain.repository.ChatRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.dao.MessageDao messageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.security.EncryptionManager encryptionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.common.DispatcherProvider dispatchers = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String localUserId = "local-user";
    
    @javax.inject.Inject()
    public ChatRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.MessageDao messageDao, @org.jetbrains.annotations.NotNull()
    com.company.app.core.security.EncryptionManager encryptionManager, @org.jetbrains.annotations.NotNull()
    com.company.app.core.common.DispatcherProvider dispatchers) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.company.app.domain.model.Message>> observeMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}