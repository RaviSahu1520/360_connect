package com.company.app.presentation.permissions;

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
public final class PermissionOnboardingViewModel_Factory implements Factory<PermissionOnboardingViewModel> {
  private final Provider<PermissionsManager> permissionsManagerProvider;

  public PermissionOnboardingViewModel_Factory(
      Provider<PermissionsManager> permissionsManagerProvider) {
    this.permissionsManagerProvider = permissionsManagerProvider;
  }

  @Override
  public PermissionOnboardingViewModel get() {
    return newInstance(permissionsManagerProvider.get());
  }

  public static PermissionOnboardingViewModel_Factory create(
      Provider<PermissionsManager> permissionsManagerProvider) {
    return new PermissionOnboardingViewModel_Factory(permissionsManagerProvider);
  }

  public static PermissionOnboardingViewModel newInstance(PermissionsManager permissionsManager) {
    return new PermissionOnboardingViewModel(permissionsManager);
  }
}
