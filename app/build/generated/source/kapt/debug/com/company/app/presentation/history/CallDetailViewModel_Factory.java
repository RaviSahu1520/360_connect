package com.company.app.presentation.history;

import com.company.app.domain.usecase.ai.CallScopedRAGQueryUseCase;
import com.company.app.domain.usecase.call.GetCallDetailUseCase;
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
public final class CallDetailViewModel_Factory implements Factory<CallDetailViewModel> {
  private final Provider<GetCallDetailUseCase> getCallDetailUseCaseProvider;

  private final Provider<CallScopedRAGQueryUseCase> callScopedRagQueryUseCaseProvider;

  public CallDetailViewModel_Factory(Provider<GetCallDetailUseCase> getCallDetailUseCaseProvider,
      Provider<CallScopedRAGQueryUseCase> callScopedRagQueryUseCaseProvider) {
    this.getCallDetailUseCaseProvider = getCallDetailUseCaseProvider;
    this.callScopedRagQueryUseCaseProvider = callScopedRagQueryUseCaseProvider;
  }

  @Override
  public CallDetailViewModel get() {
    return newInstance(getCallDetailUseCaseProvider.get(), callScopedRagQueryUseCaseProvider.get());
  }

  public static CallDetailViewModel_Factory create(
      Provider<GetCallDetailUseCase> getCallDetailUseCaseProvider,
      Provider<CallScopedRAGQueryUseCase> callScopedRagQueryUseCaseProvider) {
    return new CallDetailViewModel_Factory(getCallDetailUseCaseProvider, callScopedRagQueryUseCaseProvider);
  }

  public static CallDetailViewModel newInstance(GetCallDetailUseCase getCallDetailUseCase,
      CallScopedRAGQueryUseCase callScopedRagQueryUseCase) {
    return new CallDetailViewModel(getCallDetailUseCase, callScopedRagQueryUseCase);
  }
}
