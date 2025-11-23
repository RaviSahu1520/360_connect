package com.company.app.data.ai.engine;

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
public final class TFLiteEmbedder_Factory implements Factory<TFLiteEmbedder> {
  private final Provider<AssetExtractor> assetExtractorProvider;

  public TFLiteEmbedder_Factory(Provider<AssetExtractor> assetExtractorProvider) {
    this.assetExtractorProvider = assetExtractorProvider;
  }

  @Override
  public TFLiteEmbedder get() {
    return newInstance(assetExtractorProvider.get());
  }

  public static TFLiteEmbedder_Factory create(Provider<AssetExtractor> assetExtractorProvider) {
    return new TFLiteEmbedder_Factory(assetExtractorProvider);
  }

  public static TFLiteEmbedder newInstance(AssetExtractor assetExtractor) {
    return new TFLiteEmbedder(assetExtractor);
  }
}
