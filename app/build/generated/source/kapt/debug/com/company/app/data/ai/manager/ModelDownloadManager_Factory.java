package com.company.app.data.ai.manager;

import com.company.app.core.util.AssetExtractor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ModelDownloadManager_Factory implements Factory<ModelDownloadManager> {
  private final Provider<AssetExtractor> assetExtractorProvider;

  public ModelDownloadManager_Factory(Provider<AssetExtractor> assetExtractorProvider) {
    this.assetExtractorProvider = assetExtractorProvider;
  }

  @Override
  public ModelDownloadManager get() {
    return newInstance(assetExtractorProvider.get());
  }

  public static ModelDownloadManager_Factory create(
      Provider<AssetExtractor> assetExtractorProvider) {
    return new ModelDownloadManager_Factory(assetExtractorProvider);
  }

  public static ModelDownloadManager newInstance(AssetExtractor assetExtractor) {
    return new ModelDownloadManager(assetExtractor);
  }
}
