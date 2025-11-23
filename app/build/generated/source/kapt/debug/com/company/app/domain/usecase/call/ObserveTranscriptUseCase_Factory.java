package com.company.app.domain.usecase.call;

import com.company.app.domain.repository.CallRepository;
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
public final class ObserveTranscriptUseCase_Factory implements Factory<ObserveTranscriptUseCase> {
  private final Provider<CallRepository> repositoryProvider;

  public ObserveTranscriptUseCase_Factory(Provider<CallRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ObserveTranscriptUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ObserveTranscriptUseCase_Factory create(
      Provider<CallRepository> repositoryProvider) {
    return new ObserveTranscriptUseCase_Factory(repositoryProvider);
  }

  public static ObserveTranscriptUseCase newInstance(CallRepository repository) {
    return new ObserveTranscriptUseCase(repository);
  }
}
