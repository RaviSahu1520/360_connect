package com.company.app.domain.usecase.ai;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0086B\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/company/app/domain/usecase/ai/CallScopedRAGQueryUseCase;", "", "embedder", "Lcom/company/app/data/ai/engine/TFLiteEmbedder;", "vectorStore", "Lcom/company/app/data/local/vector/VectorStore;", "llm", "Lcom/company/app/data/ai/engine/MediaPipeLLM;", "(Lcom/company/app/data/ai/engine/TFLiteEmbedder;Lcom/company/app/data/local/vector/VectorStore;Lcom/company/app/data/ai/engine/MediaPipeLLM;)V", "invoke", "Lkotlin/Result;", "", "callId", "", "query", "invoke-0E7RQCE", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CallScopedRAGQueryUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.ai.engine.TFLiteEmbedder embedder = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.local.vector.VectorStore vectorStore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.data.ai.engine.MediaPipeLLM llm = null;
    
    @javax.inject.Inject()
    public CallScopedRAGQueryUseCase(@org.jetbrains.annotations.NotNull()
    com.company.app.data.ai.engine.TFLiteEmbedder embedder, @org.jetbrains.annotations.NotNull()
    com.company.app.data.local.vector.VectorStore vectorStore, @org.jetbrains.annotations.NotNull()
    com.company.app.data.ai.engine.MediaPipeLLM llm) {
        super();
    }
}