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
public final class GetCallDetailUseCase_Factory implements Factory<GetCallDetailUseCase> {
  private final Provider<CallRepository> callRepositoryProvider;

  public GetCallDetailUseCase_Factory(Provider<CallRepository> callRepositoryProvider) {
    this.callRepositoryProvider = callRepositoryProvider;
  }

  @Override
  public GetCallDetailUseCase get() {
    return newInstance(callRepositoryProvider.get());
  }

  public static GetCallDetailUseCase_Factory create(
      Provider<CallRepository> callRepositoryProvider) {
    return new GetCallDetailUseCase_Factory(callRepositoryProvider);
  }

  public static GetCallDetailUseCase newInstance(CallRepository callRepository) {
    return new GetCallDetailUseCase(callRepository);
  }
}
