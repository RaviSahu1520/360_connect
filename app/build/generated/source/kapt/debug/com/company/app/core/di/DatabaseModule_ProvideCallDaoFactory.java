package com.company.app.core.di;

import com.company.app.data.local.dao.CallDao;
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
public final class DatabaseModule_ProvideCallDaoFactory implements Factory<CallDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideCallDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public CallDao get() {
    return provideCallDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideCallDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideCallDaoFactory(appDatabaseProvider);
  }

  public static CallDao provideCallDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCallDao(appDatabase));
  }
}
