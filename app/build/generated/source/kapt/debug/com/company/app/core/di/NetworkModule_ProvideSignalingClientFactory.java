package com.company.app.core.di;

import com.company.app.data.remote.SignalingClient;
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
public final class NetworkModule_ProvideSignalingClientFactory implements Factory<SignalingClient> {
  @Override
  public SignalingClient get() {
    return provideSignalingClient();
  }

  public static NetworkModule_ProvideSignalingClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SignalingClient provideSignalingClient() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideSignalingClient());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideSignalingClientFactory INSTANCE = new NetworkModule_ProvideSignalingClientFactory();
  }
}
