package com.company.app.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.company.app.data.ai.engine.TFLiteEmbedder;
import com.company.app.data.local.dao.TranscriptDao;
import com.company.app.data.local.vector.VectorStore;
import dagger.internal.DaggerGenerated;
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
public final class EmbeddingWorker_Factory {
  private final Provider<TFLiteEmbedder> embedderProvider;

  private final Provider<VectorStore> vectorStoreProvider;

  private final Provider<TranscriptDao> transcriptDaoProvider;

  public EmbeddingWorker_Factory(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<TranscriptDao> transcriptDaoProvider) {
    this.embedderProvider = embedderProvider;
    this.vectorStoreProvider = vectorStoreProvider;
    this.transcriptDaoProvider = transcriptDaoProvider;
  }

  public EmbeddingWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, embedderProvider.get(), vectorStoreProvider.get(), transcriptDaoProvider.get());
  }

  public static EmbeddingWorker_Factory create(Provider<TFLiteEmbedder> embedderProvider,
      Provider<VectorStore> vectorStoreProvider, Provider<TranscriptDao> transcriptDaoProvider) {
    return new EmbeddingWorker_Factory(embedderProvider, vectorStoreProvider, transcriptDaoProvider);
  }

  public static EmbeddingWorker newInstance(Context appContext, WorkerParameters workerParams,
      TFLiteEmbedder embedder, VectorStore vectorStore, TranscriptDao transcriptDao) {
    return new EmbeddingWorker(appContext, workerParams, embedder, vectorStore, transcriptDao);
  }
}
