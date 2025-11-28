package com.company.app.core.di;

import com.company.app.data.local.vector.EmbeddingConverters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AIModule_ProvideEmbeddingConvertersFactory implements Factory<EmbeddingConverters> {
  @Override
  public EmbeddingConverters get() {
    return provideEmbeddingConverters();
  }

  public static AIModule_ProvideEmbeddingConvertersFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static EmbeddingConverters provideEmbeddingConverters() {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideEmbeddingConverters());
  }

  private static final class InstanceHolder {
    private static final AIModule_ProvideEmbeddingConvertersFactory INSTANCE = new AIModule_ProvideEmbeddingConvertersFactory();
  }
}
