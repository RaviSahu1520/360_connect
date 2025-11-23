package com.company.app.core.di;

import com.company.app.data.local.dao.TranscriptDao;
import com.company.app.data.local.db.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideTranscriptDaoFactory implements Factory<TranscriptDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideTranscriptDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public TranscriptDao get() {
    return provideTranscriptDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideTranscriptDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideTranscriptDaoFactory(appDatabaseProvider);
  }

  public static TranscriptDao provideTranscriptDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTranscriptDao(appDatabase));
  }
}
