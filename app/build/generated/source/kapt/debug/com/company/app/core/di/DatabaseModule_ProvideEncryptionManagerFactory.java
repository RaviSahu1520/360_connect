package com.company.app.core.di;

import com.company.app.core.security.EncryptionManager;
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
public final class DatabaseModule_ProvideEncryptionManagerFactory implements Factory<EncryptionManager> {
  @Override
  public EncryptionManager get() {
    return provideEncryptionManager();
  }

  public static DatabaseModule_ProvideEncryptionManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static EncryptionManager provideEncryptionManager() {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEncryptionManager());
  }

  private static final class InstanceHolder {
    private static final DatabaseModule_ProvideEncryptionManagerFactory INSTANCE = new DatabaseModule_ProvideEncryptionManagerFactory();
  }
}
