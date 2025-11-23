package com.company.app.platform.recording;

import android.content.Context;
import com.company.app.core.common.DispatcherProvider;
import com.company.app.domain.repository.CallRepository;
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
public final class CallRecordingController_Factory implements Factory<CallRecordingController> {
  private final Provider<Context> contextProvider;

  private final Provider<CallRepository> callRepositoryProvider;

  private final Provider<AudioCaptureManager> audioCaptureManagerProvider;

  private final Provider<DispatcherProvider> dispatchersProvider;

  public CallRecordingController_Factory(Provider<Context> contextProvider,
      Provider<CallRepository> callRepositoryProvider,
      Provider<AudioCaptureManager> audioCaptureManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    this.contextProvider = contextProvider;
    this.callRepositoryProvider = callRepositoryProvider;
    this.audioCaptureManagerProvider = audioCaptureManagerProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public CallRecordingController get() {
    return newInstance(contextProvider.get(), callRepositoryProvider.get(), audioCaptureManagerProvider.get(), dispatchersProvider.get());
  }

  public static CallRecordingController_Factory create(Provider<Context> contextProvider,
      Provider<CallRepository> callRepositoryProvider,
      Provider<AudioCaptureManager> audioCaptureManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    return new CallRecordingController_Factory(contextProvider, callRepositoryProvider, audioCaptureManagerProvider, dispatchersProvider);
  }

  public static CallRecordingController newInstance(Context context, CallRepository callRepository,
      AudioCaptureManager audioCaptureManager, DispatcherProvider dispatchers) {
    return new CallRecordingController(context, callRepository, audioCaptureManager, dispatchers);
  }
}
