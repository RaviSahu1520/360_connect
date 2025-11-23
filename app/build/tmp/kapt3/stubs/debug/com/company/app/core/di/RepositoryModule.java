package com.company.app.core.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/company/app/core/di/RepositoryModule;", "", "()V", "bindAIRepository", "Lcom/company/app/domain/repository/AIRepository;", "impl", "Lcom/company/app/data/repository/AIRepositoryImpl;", "bindCallRepository", "Lcom/company/app/domain/repository/CallRepository;", "Lcom/company/app/data/repository/CallRepositoryImpl;", "bindChatRepository", "Lcom/company/app/domain/repository/ChatRepository;", "Lcom/company/app/data/repository/ChatRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.domain.repository.ChatRepository bindChatRepository(@org.jetbrains.annotations.NotNull()
    com.company.app.data.repository.ChatRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.domain.repository.CallRepository bindCallRepository(@org.jetbrains.annotations.NotNull()
    com.company.app.data.repository.CallRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.domain.repository.AIRepository bindAIRepository(@org.jetbrains.annotations.NotNull()
    com.company.app.data.repository.AIRepositoryImpl impl);
}