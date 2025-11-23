package com.company.app.presentation.ai;

import com.company.app.domain.usecase.ai.RagQueryUseCase;
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
public final class AskAiViewModel_Factory implements Factory<AskAiViewModel> {
  private final Provider<RagQueryUseCase> ragQueryUseCaseProvider;

  public AskAiViewModel_Factory(Provider<RagQueryUseCase> ragQueryUseCaseProvider) {
    this.ragQueryUseCaseProvider = ragQueryUseCaseProvider;
  }

  @Override
  public AskAiViewModel get() {
    return newInstance(ragQueryUseCaseProvider.get());
  }

  public static AskAiViewModel_Factory create(Provider<RagQueryUseCase> ragQueryUseCaseProvider) {
    return new AskAiViewModel_Factory(ragQueryUseCaseProvider);
  }

  public static AskAiViewModel newInstance(RagQueryUseCase ragQueryUseCase) {
    return new AskAiViewModel(ragQueryUseCase);
  }
}
