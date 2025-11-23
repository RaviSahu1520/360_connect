package com.company.app.platform.recording;

import com.company.app.core.common.DispatcherProvider;
import com.company.app.domain.repository.CallRepository;
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
public final class CallRecordingService_MembersInjector implements MembersInjector<CallRecordingService> {
  private final Provider<AudioCaptureManager> audioCaptureManagerProvider;

  private final Provider<CallRepository> callRepositoryProvider;

  private final Provider<DispatcherProvider> dispatchersProvider;

  public CallRecordingService_MembersInjector(
      Provider<AudioCaptureManager> audioCaptureManagerProvider,
      Provider<CallRepository> callRepositoryProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    this.audioCaptureManagerProvider = audioCaptureManagerProvider;
    this.callRepositoryProvider = callRepositoryProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  public static MembersInjector<CallRecordingService> create(
      Provider<AudioCaptureManager> audioCaptureManagerProvider,
      Provider<CallRepository> callRepositoryProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    return new CallRecordingService_MembersInjector(audioCaptureManagerProvider, callRepositoryProvider, dispatchersProvider);
  }

  @Override
  public void injectMembers(CallRecordingService instance) {
    injectAudioCaptureManager(instance, audioCaptureManagerProvider.get());
    injectCallRepository(instance, callRepositoryProvider.get());
    injectDispatchers(instance, dispatchersProvider.get());
  }

  @InjectedFieldSignature("com.company.app.platform.recording.CallRecordingService.audioCaptureManager")
  public static void injectAudioCaptureManager(CallRecordingService instance,
      AudioCaptureManager audioCaptureManager) {
    instance.audioCaptureManager = audioCaptureManager;
  }

  @InjectedFieldSignature("com.company.app.platform.recording.CallRecordingService.callRepository")
  public static void injectCallRepository(CallRecordingService instance,
      CallRepository callRepository) {
    instance.callRepository = callRepository;
  }

  @InjectedFieldSignature("com.company.app.platform.recording.CallRecordingService.dispatchers")
  public static void injectDispatchers(CallRecordingService instance,
      DispatcherProvider dispatchers) {
    instance.dispatchers = dispatchers;
  }
}
