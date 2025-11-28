package com.company.app.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.company.app.data.local.dao.TranscriptDao;
import com.company.app.data.remote.llm.LLMEngine;
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
  private final Provider<LLMEngine> llmEngineProvider;

  private final Provider<TranscriptDao> transcriptDaoProvider;

  public SummarizationWorker_Factory(Provider<LLMEngine> llmEngineProvider,
      Provider<TranscriptDao> transcriptDaoProvider) {
    this.llmEngineProvider = llmEngineProvider;
    this.transcriptDaoProvider = transcriptDaoProvider;
  }

  public SummarizationWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, llmEngineProvider.get(), transcriptDaoProvider.get());
  }

  public static SummarizationWorker_Factory create(Provider<LLMEngine> llmEngineProvider,
      Provider<TranscriptDao> transcriptDaoProvider) {
    return new SummarizationWorker_Factory(llmEngineProvider, transcriptDaoProvider);
  }

  public static SummarizationWorker newInstance(Context appContext, WorkerParameters workerParams,
      LLMEngine llmEngine, TranscriptDao transcriptDao) {
    return new SummarizationWorker(appContext, workerParams, llmEngine, transcriptDao);
  }
}
