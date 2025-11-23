package com.company.app.presentation;

import com.company.app.platform.recording.AudioCaptureManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<AudioCaptureManager> audioCaptureManagerProvider;

  public MainActivity_MembersInjector(Provider<AudioCaptureManager> audioCaptureManagerProvider) {
    this.audioCaptureManagerProvider = audioCaptureManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<AudioCaptureManager> audioCaptureManagerProvider) {
    return new MainActivity_MembersInjector(audioCaptureManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectAudioCaptureManager(instance, audioCaptureManagerProvider.get());
  }

  @InjectedFieldSignature("com.company.app.presentation.MainActivity.audioCaptureManager")
  public static void injectAudioCaptureManager(MainActivity instance,
      AudioCaptureManager audioCaptureManager) {
    instance.audioCaptureManager = audioCaptureManager;
  }
}
