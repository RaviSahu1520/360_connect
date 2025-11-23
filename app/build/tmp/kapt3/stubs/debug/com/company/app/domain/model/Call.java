package com.company.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u000eH\u00c6\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/company/app/domain/model/Call;", "", "id", "", "remoteUserId", "", "source", "type", "Lcom/company/app/domain/model/CallType;", "timestamp", "Lkotlinx/datetime/Instant;", "durationMillis", "audioFilePath", "transcriptionStatus", "Lcom/company/app/domain/model/TranscriptionStatus;", "(JLjava/lang/String;Ljava/lang/String;Lcom/company/app/domain/model/CallType;Lkotlinx/datetime/Instant;JLjava/lang/String;Lcom/company/app/domain/model/TranscriptionStatus;)V", "getAudioFilePath", "()Ljava/lang/String;", "getDurationMillis", "()J", "getId", "getRemoteUserId", "getSource", "getTimestamp", "()Lkotlinx/datetime/Instant;", "getTranscriptionStatus", "()Lcom/company/app/domain/model/TranscriptionStatus;", "getType", "()Lcom/company/app/domain/model/CallType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Call {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String remoteUserId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String source = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.model.CallType type = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.Instant timestamp = null;
    private final long durationMillis = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String audioFilePath = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.model.TranscriptionStatus transcriptionStatus = null;
    
    public Call(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteUserId, @org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.CallType type, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.Instant timestamp, long durationMillis, @org.jetbrains.annotations.NotNull()
    java.lang.String audioFilePath, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.TranscriptionStatus transcriptionStatus) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRemoteUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.model.CallType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.Instant getTimestamp() {
        return null;
    }
    
    public final long getDurationMillis() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAudioFilePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.model.TranscriptionStatus getTranscriptionStatus() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.model.CallType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.Instant component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.model.TranscriptionStatus component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.app.domain.model.Call copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteUserId, @org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.CallType type, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.Instant timestamp, long durationMillis, @org.jetbrains.annotations.NotNull()
    java.lang.String audioFilePath, @org.jetbrains.annotations.NotNull()
    com.company.app.domain.model.TranscriptionStatus transcriptionStatus) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}