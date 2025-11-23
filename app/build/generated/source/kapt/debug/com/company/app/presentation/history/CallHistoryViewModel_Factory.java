package com.company.app.presentation.history;

import com.company.app.domain.usecase.call.GetCallHistoryUseCase;
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
public final class CallHistoryViewModel_Factory implements Factory<CallHistoryViewModel> {
  private final Provider<GetCallHistoryUseCase> getCallHistoryUseCaseProvider;

  public CallHistoryViewModel_Factory(
      Provider<GetCallHistoryUseCase> getCallHistoryUseCaseProvider) {
    this.getCallHistoryUseCaseProvider = getCallHistoryUseCaseProvider;
  }

  @Override
  public CallHistoryViewModel get() {
    return newInstance(getCallHistoryUseCaseProvider.get());
  }

  public static CallHistoryViewModel_Factory create(
      Provider<GetCallHistoryUseCase> getCallHistoryUseCaseProvider) {
    return new CallHistoryViewModel_Factory(getCallHistoryUseCaseProvider);
  }

  public static CallHistoryViewModel newInstance(GetCallHistoryUseCase getCallHistoryUseCase) {
    return new CallHistoryViewModel(getCallHistoryUseCase);
  }
}
