package com.company.app.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.company.app.data.ai.engine.WhisperEngine;
import com.company.app.data.local.dao.CallDao;
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
public final class TranscriptionWorker_Factory {
  private final Provider<WhisperEngine> whisperEngineProvider;

  private final Provider<TranscriptDao> transcriptDaoProvider;

  private final Provider<CallDao> callDaoProvider;

  public TranscriptionWorker_Factory(Provider<WhisperEngine> whisperEngineProvider,
      Provider<TranscriptDao> transcriptDaoProvider, Provider<CallDao> callDaoProvider) {
    this.whisperEngineProvider = whisperEngineProvider;
    this.transcriptDaoProvider = transcriptDaoProvider;
    this.callDaoProvider = callDaoProvider;
  }

  public TranscriptionWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, whisperEngineProvider.get(), transcriptDaoProvider.get(), callDaoProvider.get());
  }

  public static TranscriptionWorker_Factory create(Provider<WhisperEngine> whisperEngineProvider,
      Provider<TranscriptDao> transcriptDaoProvider, Provider<CallDao> callDaoProvider) {
    return new TranscriptionWorker_Factory(whisperEngineProvider, transcriptDaoProvider, callDaoProvider);
  }

  public static TranscriptionWorker newInstance(Context appContext, WorkerParameters workerParams,
      WhisperEngine whisperEngine, TranscriptDao transcriptDao, CallDao callDao) {
    return new TranscriptionWorker(appContext, workerParams, whisperEngine, transcriptDao, callDao);
  }
}
