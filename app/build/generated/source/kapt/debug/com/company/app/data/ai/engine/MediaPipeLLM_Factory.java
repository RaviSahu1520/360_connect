package com.company.app.data.ai.engine;

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
public final class MediaPipeLLM_Factory implements Factory<MediaPipeLLM> {
  @Override
  public MediaPipeLLM get() {
    return newInstance();
  }

  public static MediaPipeLLM_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MediaPipeLLM newInstance() {
    return new MediaPipeLLM();
  }

  private static final class InstanceHolder {
    private static final MediaPipeLLM_Factory INSTANCE = new MediaPipeLLM_Factory();
  }
}
