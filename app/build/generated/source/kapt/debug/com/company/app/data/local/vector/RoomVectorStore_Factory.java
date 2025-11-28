package com.company.app.data.local.vector;

import com.company.app.data.local.dao.EmbeddingDao;
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
public final class RoomVectorStore_Factory implements Factory<RoomVectorStore> {
  private final Provider<EmbeddingDao> embeddingDaoProvider;

  private final Provider<EmbeddingConverters> convertersProvider;

  public RoomVectorStore_Factory(Provider<EmbeddingDao> embeddingDaoProvider,
      Provider<EmbeddingConverters> convertersProvider) {
    this.embeddingDaoProvider = embeddingDaoProvider;
    this.convertersProvider = convertersProvider;
  }

  @Override
  public RoomVectorStore get() {
    return newInstance(embeddingDaoProvider.get(), convertersProvider.get());
  }

  public static RoomVectorStore_Factory create(Provider<EmbeddingDao> embeddingDaoProvider,
      Provider<EmbeddingConverters> convertersProvider) {
    return new RoomVectorStore_Factory(embeddingDaoProvider, convertersProvider);
  }

  public static RoomVectorStore newInstance(EmbeddingDao embeddingDao,
      EmbeddingConverters converters) {
    return new RoomVectorStore(embeddingDao, converters);
  }
}
