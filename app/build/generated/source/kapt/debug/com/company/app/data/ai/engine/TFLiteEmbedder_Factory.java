package com.company.app.data.ai.engine;

import android.content.Context;
import com.company.app.core.util.AssetExtractor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
  private final Provider<Context> contextProvider;

  private final Provider<AssetExtractor> assetExtractorProvider;

  public TFLiteEmbedder_Factory(Provider<Context> contextProvider,
      Provider<AssetExtractor> assetExtractorProvider) {
    this.contextProvider = contextProvider;
    this.assetExtractorProvider = assetExtractorProvider;
  }

  @Override
  public TFLiteEmbedder get() {
    return newInstance(contextProvider.get(), assetExtractorProvider.get());
  }

  public static TFLiteEmbedder_Factory create(Provider<Context> contextProvider,
      Provider<AssetExtractor> assetExtractorProvider) {
    return new TFLiteEmbedder_Factory(contextProvider, assetExtractorProvider);
  }

  public static TFLiteEmbedder newInstance(Context context, AssetExtractor assetExtractor) {
    return new TFLiteEmbedder(context, assetExtractor);
  }
}
