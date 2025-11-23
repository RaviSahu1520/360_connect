package com.company.app.data.repository;

import com.company.app.data.ai.engine.MediaPipeLLM;
import com.company.app.data.ai.engine.TFLiteEmbedder;
import com.company.app.data.ai.engine.WhisperEngine;
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
public final class AIRepositoryImpl_Factory implements Factory<AIRepositoryImpl> {
  private final Provider<WhisperEngine> whisperEngineProvider;

  private final Provider<MediaPipeLLM> llmProvider;

  private final Provider<TFLiteEmbedder> embedderProvider;

  private final Provider<VectorStore> vectorStoreProvider;

  public AIRepositoryImpl_Factory(Provider<WhisperEngine> whisperEngineProvider,
      Provider<MediaPipeLLM> llmProvider, Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider) {
    this.whisperEngineProvider = whisperEngineProvider;
    this.llmProvider = llmProvider;
    this.embedderProvider = embedderProvider;
    this.vectorStoreProvider = vectorStoreProvider;
  }

  @Override
  public AIRepositoryImpl get() {
    return newInstance(whisperEngineProvider.get(), llmProvider.get(), embedderProvider.get(), vectorStoreProvider.get());
  }

  public static AIRepositoryImpl_Factory create(Provider<WhisperEngine> whisperEngineProvider,
      Provider<MediaPipeLLM> llmProvider, Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider) {
    return new AIRepositoryImpl_Factory(whisperEngineProvider, llmProvider, embedderProvider, vectorStoreProvider);
  }

  public static AIRepositoryImpl newInstance(WhisperEngine whisperEngine, MediaPipeLLM llm,
      TFLiteEmbedder embedder, VectorStore vectorStore) {
    return new AIRepositoryImpl(whisperEngine, llm, embedder, vectorStore);
  }
}
