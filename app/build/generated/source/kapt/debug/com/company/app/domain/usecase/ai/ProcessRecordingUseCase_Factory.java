package com.company.app.domain.usecase.ai;

import com.company.app.domain.repository.AIRepository;
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
public final class ProcessRecordingUseCase_Factory implements Factory<ProcessRecordingUseCase> {
  private final Provider<AIRepository> repositoryProvider;

  public ProcessRecordingUseCase_Factory(Provider<AIRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ProcessRecordingUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ProcessRecordingUseCase_Factory create(Provider<AIRepository> repositoryProvider) {
    return new ProcessRecordingUseCase_Factory(repositoryProvider);
  }

  public static ProcessRecordingUseCase newInstance(AIRepository repository) {
    return new ProcessRecordingUseCase(repository);
  }
}
