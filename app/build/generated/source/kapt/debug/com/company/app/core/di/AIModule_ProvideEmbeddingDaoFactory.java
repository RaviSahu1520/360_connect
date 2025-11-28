package com.company.app.core.di;

import com.company.app.data.local.dao.EmbeddingDao;
import com.company.app.data.local.db.AppDatabase;
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
public final class AIModule_ProvideEmbeddingDaoFactory implements Factory<EmbeddingDao> {
  private final Provider<AppDatabase> dbProvider;

  public AIModule_ProvideEmbeddingDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public EmbeddingDao get() {
    return provideEmbeddingDao(dbProvider.get());
  }

  public static AIModule_ProvideEmbeddingDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AIModule_ProvideEmbeddingDaoFactory(dbProvider);
  }

  public static EmbeddingDao provideEmbeddingDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideEmbeddingDao(db));
  }
}
