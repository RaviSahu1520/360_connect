package com.company.app.core.di;

import com.company.app.data.remote.llm.LLMEngine;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class AIModule_ProvideLLMEngineFactory implements Factory<LLMEngine> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public AIModule_ProvideLLMEngineFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public LLMEngine get() {
    return provideLLMEngine(okHttpClientProvider.get());
  }

  public static AIModule_ProvideLLMEngineFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new AIModule_ProvideLLMEngineFactory(okHttpClientProvider);
  }

  public static LLMEngine provideLLMEngine(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideLLMEngine(okHttpClient));
  }
}
