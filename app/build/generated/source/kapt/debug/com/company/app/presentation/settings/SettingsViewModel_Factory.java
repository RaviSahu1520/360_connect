package com.company.app.presentation.settings;

import com.company.app.data.ai.manager.ModelDownloadManager;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<ModelDownloadManager> modelDownloadManagerProvider;

  private final Provider<PermissionsManager> permissionsManagerProvider;

  public SettingsViewModel_Factory(Provider<ModelDownloadManager> modelDownloadManagerProvider,
      Provider<PermissionsManager> permissionsManagerProvider) {
    this.modelDownloadManagerProvider = modelDownloadManagerProvider;
    this.permissionsManagerProvider = permissionsManagerProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(modelDownloadManagerProvider.get(), permissionsManagerProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<ModelDownloadManager> modelDownloadManagerProvider,
      Provider<PermissionsManager> permissionsManagerProvider) {
    return new SettingsViewModel_Factory(modelDownloadManagerProvider, permissionsManagerProvider);
  }

  public static SettingsViewModel newInstance(ModelDownloadManager modelDownloadManager,
      PermissionsManager permissionsManager) {
    return new SettingsViewModel(modelDownloadManager, permissionsManager);
  }
}
