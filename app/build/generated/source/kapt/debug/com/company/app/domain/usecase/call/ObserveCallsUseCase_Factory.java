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
public final class ObserveCallsUseCase_Factory implements Factory<ObserveCallsUseCase> {
  private final Provider<CallRepository> repositoryProvider;

  public ObserveCallsUseCase_Factory(Provider<CallRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ObserveCallsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ObserveCallsUseCase_Factory create(Provider<CallRepository> repositoryProvider) {
    return new ObserveCallsUseCase_Factory(repositoryProvider);
  }

  public static ObserveCallsUseCase newInstance(CallRepository repository) {
    return new ObserveCallsUseCase(repository);
  }
}
