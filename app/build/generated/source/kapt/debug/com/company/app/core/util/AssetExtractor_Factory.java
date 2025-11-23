package com.company.app.core.util;

import android.content.Context;
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
public final class AssetExtractor_Factory implements Factory<AssetExtractor> {
  private final Provider<Context> contextProvider;

  public AssetExtractor_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AssetExtractor get() {
    return newInstance(contextProvider.get());
  }

  public static AssetExtractor_Factory create(Provider<Context> contextProvider) {
    return new AssetExtractor_Factory(contextProvider);
  }

  public static AssetExtractor newInstance(Context context) {
    return new AssetExtractor(context);
  }
}
