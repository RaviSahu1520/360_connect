package com.company.app.data.ai.engine;

import android.content.Context;
import com.company.app.core.common.DispatcherProvider;
import com.company.app.core.util.AssetExtractor;
import com.company.app.core.util.AudioDecoder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class WhisperEngine_Factory implements Factory<WhisperEngine> {
  private final Provider<Context> contextProvider;

  private final Provider<DispatcherProvider> dispatchersProvider;

  private final Provider<AssetExtractor> assetExtractorProvider;

  private final Provider<AudioDecoder> audioDecoderProvider;

  public WhisperEngine_Factory(Provider<Context> contextProvider,
      Provider<DispatcherProvider> dispatchersProvider,
      Provider<AssetExtractor> assetExtractorProvider,
      Provider<AudioDecoder> audioDecoderProvider) {
    this.contextProvider = contextProvider;
    this.dispatchersProvider = dispatchersProvider;
    this.assetExtractorProvider = assetExtractorProvider;
    this.audioDecoderProvider = audioDecoderProvider;
  }

  @Override
  public WhisperEngine get() {
    return newInstance(contextProvider.get(), dispatchersProvider.get(), assetExtractorProvider.get(), audioDecoderProvider.get());
  }

  public static WhisperEngine_Factory create(Provider<Context> contextProvider,
      Provider<DispatcherProvider> dispatchersProvider,
      Provider<AssetExtractor> assetExtractorProvider,
      Provider<AudioDecoder> audioDecoderProvider) {
    return new WhisperEngine_Factory(contextProvider, dispatchersProvider, assetExtractorProvider, audioDecoderProvider);
  }

  public static WhisperEngine newInstance(Context context, DispatcherProvider dispatchers,
      AssetExtractor assetExtractor, AudioDecoder audioDecoder) {
    return new WhisperEngine(context, dispatchers, assetExtractor, audioDecoder);
  }
}
