package com.company.app.presentation.home;

import com.company.app.domain.usecase.call.ObserveCallsUseCase;
import com.company.app.presentation.permissions.PermissionsManager;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ObserveCallsUseCase> observeCallsUseCaseProvider;

  private final Provider<PermissionsManager> permissionsManagerProvider;

  public HomeViewModel_Factory(Provider<ObserveCallsUseCase> observeCallsUseCaseProvider,
      Provider<PermissionsManager> permissionsManagerProvider) {
    this.observeCallsUseCaseProvider = observeCallsUseCaseProvider;
    this.permissionsManagerProvider = permissionsManagerProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(observeCallsUseCaseProvider.get(), permissionsManagerProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<ObserveCallsUseCase> observeCallsUseCaseProvider,
      Provider<PermissionsManager> permissionsManagerProvider) {
    return new HomeViewModel_Factory(observeCallsUseCaseProvider, permissionsManagerProvider);
  }

  public static HomeViewModel newInstance(ObserveCallsUseCase observeCallsUseCase,
      PermissionsManager permissionsManager) {
    return new HomeViewModel(observeCallsUseCase, permissionsManager);
  }
}
