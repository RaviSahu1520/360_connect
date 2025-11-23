package com.company.app.core.di;

import com.company.app.core.common.DispatcherProvider;
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
public final class DispatcherModule_ProvideDispatchersFactory implements Factory<DispatcherProvider> {
  @Override
  public DispatcherProvider get() {
    return provideDispatchers();
  }

  public static DispatcherModule_ProvideDispatchersFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DispatcherProvider provideDispatchers() {
    return Preconditions.checkNotNullFromProvides(DispatcherModule.INSTANCE.provideDispatchers());
  }

  private static final class InstanceHolder {
    private static final DispatcherModule_ProvideDispatchersFactory INSTANCE = new DispatcherModule_ProvideDispatchersFactory();
  }
}
