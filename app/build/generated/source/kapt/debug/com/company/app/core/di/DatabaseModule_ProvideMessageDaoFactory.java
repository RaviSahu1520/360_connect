package com.company.app.core.di;

import com.company.app.data.local.dao.MessageDao;
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
public final class DatabaseModule_ProvideMessageDaoFactory implements Factory<MessageDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideMessageDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public MessageDao get() {
    return provideMessageDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideMessageDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideMessageDaoFactory(appDatabaseProvider);
  }

  public static MessageDao provideMessageDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMessageDao(appDatabase));
  }
}
