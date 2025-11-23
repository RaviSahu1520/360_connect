package com.company.app.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.company.app.data.ai.engine.MediaPipeLLM;
import com.company.app.data.local.dao.TranscriptDao;
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
public final class SummarizationWorker_Factory {
  private final Provider<MediaPipeLLM> llmProvider;

  private final Provider<TranscriptDao> transcriptDaoProvider;

  public SummarizationWorker_Factory(Provider<MediaPipeLLM> llmProvider,
      Provider<TranscriptDao> transcriptDaoProvider) {
    this.llmProvider = llmProvider;
    this.transcriptDaoProvider = transcriptDaoProvider;
  }

  public SummarizationWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, llmProvider.get(), transcriptDaoProvider.get());
  }

  public static SummarizationWorker_Factory create(Provider<MediaPipeLLM> llmProvider,
      Provider<TranscriptDao> transcriptDaoProvider) {
    return new SummarizationWorker_Factory(llmProvider, transcriptDaoProvider);
  }

  public static SummarizationWorker newInstance(Context appContext, WorkerParameters workerParams,
      MediaPipeLLM llm, TranscriptDao transcriptDao) {
    return new SummarizationWorker(appContext, workerParams, llm, transcriptDao);
  }
}
