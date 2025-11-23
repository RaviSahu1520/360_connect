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
public final class GetCallHistoryUseCase_Factory implements Factory<GetCallHistoryUseCase> {
  private final Provider<CallRepository> callRepositoryProvider;

  public GetCallHistoryUseCase_Factory(Provider<CallRepository> callRepositoryProvider) {
    this.callRepositoryProvider = callRepositoryProvider;
  }

  @Override
  public GetCallHistoryUseCase get() {
    return newInstance(callRepositoryProvider.get());
  }

  public static GetCallHistoryUseCase_Factory create(
      Provider<CallRepository> callRepositoryProvider) {
    return new GetCallHistoryUseCase_Factory(callRepositoryProvider);
  }

  public static GetCallHistoryUseCase newInstance(CallRepository callRepository) {
    return new GetCallHistoryUseCase(callRepository);
  }
}
