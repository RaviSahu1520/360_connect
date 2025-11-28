package com.company.app.data.local.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/company/app/data/local/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "callDao", "Lcom/company/app/data/local/dao/CallDao;", "embeddingDao", "Lcom/company/app/data/local/dao/EmbeddingDao;", "messageDao", "Lcom/company/app/data/local/dao/MessageDao;", "transcriptDao", "Lcom/company/app/data/local/dao/TranscriptDao;", "app_debug"})
@androidx.room.Database(entities = {com.company.app.data.local.entity.MessageEntity.class, com.company.app.data.local.entity.CallEntity.class, com.company.app.data.local.entity.TranscriptEntity.class, com.company.app.data.local.vector.TranscriptEmbeddingEntity.class}, version = 4, exportSchema = true)
@androidx.room.TypeConverters(value = {com.company.app.data.local.db.AppTypeConverters.class, com.company.app.data.local.vector.EmbeddingConverters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.data.local.dao.MessageDao messageDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.data.local.dao.CallDao callDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.data.local.dao.TranscriptDao transcriptDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.app.data.local.dao.EmbeddingDao embeddingDao();
}