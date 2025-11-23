package com.company.app.core.di;

import com.company.app.data.local.vector.VectorStore;
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
public final class AIModule_ProvideVectorStoreFactory implements Factory<VectorStore> {
  @Override
  public VectorStore get() {
    return provideVectorStore();
  }

  public static AIModule_ProvideVectorStoreFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static VectorStore provideVectorStore() {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideVectorStore());
  }

  private static final class InstanceHolder {
    private static final AIModule_ProvideVectorStoreFactory INSTANCE = new AIModule_ProvideVectorStoreFactory();
  }
}
