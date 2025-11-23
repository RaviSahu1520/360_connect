package com.company.app.domain.usecase.ai;

import com.company.app.data.ai.engine.MediaPipeLLM;
import com.company.app.data.ai.engine.TFLiteEmbedder;
import com.company.app.data.local.vector.VectorStore;
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

  private final Provider<MediaPipeLLM> llmProvider;

  public RagQueryUseCase_Factory(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<MediaPipeLLM> llmProvider) {
    this.embedderProvider = embedderProvider;
    this.vectorStoreProvider = vectorStoreProvider;
    this.llmProvider = llmProvider;
  }

  @Override
  public RagQueryUseCase get() {
    return newInstance(embedderProvider.get(), vectorStoreProvider.get(), llmProvider.get());
  }

  public static RagQueryUseCase_Factory create(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<MediaPipeLLM> llmProvider) {
    return new RagQueryUseCase_Factory(embedderProvider, vectorStoreProvider, llmProvider);
  }

  public static RagQueryUseCase newInstance(TFLiteEmbedder embedder, VectorStore vectorStore,
      MediaPipeLLM llm) {
    return new RagQueryUseCase(embedder, vectorStore, llm);
  }
}
