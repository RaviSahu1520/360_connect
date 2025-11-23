package com.company.app.core.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/company/app/core/di/DatabaseModule;", "", "()V", "provideCallDao", "Lcom/company/app/data/local/dao/CallDao;", "appDatabase", "Lcom/company/app/data/local/db/AppDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "provideEncryptionManager", "Lcom/company/app/core/security/EncryptionManager;", "provideMessageDao", "Lcom/company/app/data/local/dao/MessageDao;", "provideTranscriptDao", "Lcom/company/app/data/local/dao/TranscriptDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.app.core.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.db.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.dao.MessageDao provideMessageDao(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.dao.CallDao provideCallDao(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.data.local.dao.TranscriptDao provideTranscriptDao(@org.jetbrains.annotations.NotNull()
    com.company.app.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.core.security.EncryptionManager provideEncryptionManager() {
        return null;
    }
}