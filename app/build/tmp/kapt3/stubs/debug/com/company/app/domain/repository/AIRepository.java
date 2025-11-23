package com.company.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/company/app/domain/repository/AIRepository;", "", "queryRag", "", "Lcom/company/app/domain/model/TranscriptChunk;", "prompt", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "summarize", "text", "transcribe", "Lkotlinx/coroutines/flow/Flow;", "audioFile", "Ljava/io/File;", "app_debug"})
public abstract interface AIRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> transcribe(@org.jetbrains.annotations.NotNull()
    java.io.File audioFile);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object summarize(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object queryRag(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.app.domain.model.TranscriptChunk>> $completion);
}