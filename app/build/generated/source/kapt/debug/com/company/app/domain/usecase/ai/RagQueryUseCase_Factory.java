package com.company.app.domain.usecase.ai;

import com.company.app.data.ai.engine.TFLiteEmbedder;
import com.company.app.data.local.vector.VectorStore;
import com.company.app.data.remote.llm.LLMEngine;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class RagQueryUseCase_Factory implements Factory<RagQueryUseCase> {
  private final Provider<TFLiteEmbedder> embedderProvider;

  private final Provider<VectorStore> vectorStoreProvider;

  private final Provider<LLMEngine> llmEngineProvider;

  public RagQueryUseCase_Factory(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<LLMEngine> llmEngineProvider) {
    this.embedderProvider = embedderProvider;
    this.vectorStoreProvider = vectorStoreProvider;
    this.llmEngineProvider = llmEngineProvider;
  }

  @Override
  public RagQueryUseCase get() {
    return newInstance(embedderProvider.get(), vectorStoreProvider.get(), llmEngineProvider.get());
  }

  public static RagQueryUseCase_Factory create(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<LLMEngine> llmEngineProvider) {
    return new RagQueryUseCase_Factory(embedderProvider, vectorStoreProvider, llmEngineProvider);
  }

  public static RagQueryUseCase newInstance(TFLiteEmbedder embedder, VectorStore vectorStore,
      LLMEngine llmEngine) {
    return new RagQueryUseCase(embedder, vectorStore, llmEngine);
  }
}
