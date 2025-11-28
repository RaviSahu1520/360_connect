package com.company.app.core.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/company/app/core/di/AIModule;", "", "()V", "provideEmbeddingConverters", "Lcom/company/app/data/local/vector/EmbeddingConverters;", "provideEmbeddingDao", "Lcom/company/app/data/local/dao/EmbeddingDao;", "db", "Lcom/company/app/data/local/db/AppDatabase;", "provideLLMEngine", "Lcom/company/app/data/remote/llm/LLMEngine;", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideVectorStore", "Lcom/company/app/data/local/vector/VectorStore;", "dao", "converters", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AIModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.core.di.AIModule INSTANCE = null;
    
    private AIModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.dao.EmbeddingDao provideEmbeddingDao(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.vector.EmbeddingConverters provideEmbeddingConverters() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.vector.VectorStore provideVectorStore(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.dao.EmbeddingDao dao, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.vector.EmbeddingConverters converters) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.remote.llm.LLMEngine provideLLMEngine(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
}