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
public final class TranscribeCallUseCase_Factory implements Factory<TranscribeCallUseCase> {
  private final Provider<AIRepository> repositoryProvider;

  public TranscribeCallUseCase_Factory(Provider<AIRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TranscribeCallUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static TranscribeCallUseCase_Factory create(Provider<AIRepository> repositoryProvider) {
    return new TranscribeCallUseCase_Factory(repositoryProvider);
  }

  public static TranscribeCallUseCase newInstance(AIRepository repository) {
    return new TranscribeCallUseCase(repository);
  }
}
