package com.company.app.presentation.call;

import com.company.app.domain.usecase.ai.RagQueryUseCase;
import com.company.app.domain.usecase.ai.TranscribeCallUseCase;
import com.company.app.domain.usecase.call.StartRecordingUseCase;
import com.company.app.domain.usecase.call.StopRecordingUseCase;
import com.company.app.platform.call.VoipClient;
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
public final class CallViewModel_Factory implements Factory<CallViewModel> {
  private final Provider<VoipClient> voipClientProvider;

  private final Provider<StartRecordingUseCase> startRecordingUseCaseProvider;

  private final Provider<StopRecordingUseCase> stopRecordingUseCaseProvider;

  private final Provider<TranscribeCallUseCase> transcribeCallUseCaseProvider;

  private final Provider<RagQueryUseCase> ragQueryUseCaseProvider;

  public CallViewModel_Factory(Provider<VoipClient> voipClientProvider,
      Provider<StartRecordingUseCase> startRecordingUseCaseProvider,
      Provider<StopRecordingUseCase> stopRecordingUseCaseProvider,
      Provider<TranscribeCallUseCase> transcribeCallUseCaseProvider,
      Provider<RagQueryUseCase> ragQueryUseCaseProvider) {
    this.voipClientProvider = voipClientProvider;
    this.startRecordingUseCaseProvider = startRecordingUseCaseProvider;
    this.stopRecordingUseCaseProvider = stopRecordingUseCaseProvider;
    this.transcribeCallUseCaseProvider = transcribeCallUseCaseProvider;
    this.ragQueryUseCaseProvider = ragQueryUseCaseProvider;
  }

  @Override
  public CallViewModel get() {
    return newInstance(voipClientProvider.get(), startRecordingUseCaseProvider.get(), stopRecordingUseCaseProvider.get(), transcribeCallUseCaseProvider.get(), ragQueryUseCaseProvider.get());
  }

  public static CallViewModel_Factory create(Provider<VoipClient> voipClientProvider,
      Provider<StartRecordingUseCase> startRecordingUseCaseProvider,
      Provider<StopRecordingUseCase> stopRecordingUseCaseProvider,
      Provider<TranscribeCallUseCase> transcribeCallUseCaseProvider,
      Provider<RagQueryUseCase> ragQueryUseCaseProvider) {
    return new CallViewModel_Factory(voipClientProvider, startRecordingUseCaseProvider, stopRecordingUseCaseProvider, transcribeCallUseCaseProvider, ragQueryUseCaseProvider);
  }

  public static CallViewModel newInstance(VoipClient voipClient,
      StartRecordingUseCase startRecordingUseCase, StopRecordingUseCase stopRecordingUseCase,
      TranscribeCallUseCase transcribeCallUseCase, RagQueryUseCase ragQueryUseCase) {
    return new CallViewModel(voipClient, startRecordingUseCase, stopRecordingUseCase, transcribeCallUseCase, ragQueryUseCase);
  }
}
