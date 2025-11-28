package com.company.app.core.di;

import com.company.app.data.local.dao.EmbeddingDao;
import com.company.app.data.local.vector.EmbeddingConverters;
import com.company.app.data.local.vector.VectorStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AIModule_ProvideVectorStoreFactory implements Factory<VectorStore> {
  private final Provider<EmbeddingDao> daoProvider;

  private final Provider<EmbeddingConverters> convertersProvider;

  public AIModule_ProvideVectorStoreFactory(Provider<EmbeddingDao> daoProvider,
      Provider<EmbeddingConverters> convertersProvider) {
    this.daoProvider = daoProvider;
    this.convertersProvider = convertersProvider;
  }

  @Override
  public VectorStore get() {
    return provideVectorStore(daoProvider.get(), convertersProvider.get());
  }

  public static AIModule_ProvideVectorStoreFactory create(Provider<EmbeddingDao> daoProvider,
      Provider<EmbeddingConverters> convertersProvider) {
    return new AIModule_ProvideVectorStoreFactory(daoProvider, convertersProvider);
  }

  public static VectorStore provideVectorStore(EmbeddingDao dao, EmbeddingConverters converters) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideVectorStore(dao, converters));
  }
}
