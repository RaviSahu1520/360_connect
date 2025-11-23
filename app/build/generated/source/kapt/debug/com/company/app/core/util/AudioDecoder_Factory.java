package com.company.app.core.util;

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
public final class AudioDecoder_Factory implements Factory<AudioDecoder> {
  @Override
  public AudioDecoder get() {
    return newInstance();
  }

  public static AudioDecoder_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AudioDecoder newInstance() {
    return new AudioDecoder();
  }

  private static final class InstanceHolder {
    private static final AudioDecoder_Factory INSTANCE = new AudioDecoder_Factory();
  }
}
