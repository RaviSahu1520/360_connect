package com.company.app.platform.call;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class VoipClient_Factory implements Factory<VoipClient> {
  @Override
  public VoipClient get() {
    return newInstance();
  }

  public static VoipClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static VoipClient newInstance() {
    return new VoipClient();
  }

  private static final class InstanceHolder {
    private static final VoipClient_Factory INSTANCE = new VoipClient_Factory();
  }
}
