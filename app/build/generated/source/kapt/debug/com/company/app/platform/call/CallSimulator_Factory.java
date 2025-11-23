package com.company.app.platform.call;

import com.company.app.platform.recording.CallRecordingController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class CallSimulator_Factory implements Factory<CallSimulator> {
  private final Provider<CallRecordingController> callRecordingControllerProvider;

  public CallSimulator_Factory(Provider<CallRecordingController> callRecordingControllerProvider) {
    this.callRecordingControllerProvider = callRecordingControllerProvider;
  }

  @Override
  public CallSimulator get() {
    return newInstance(callRecordingControllerProvider.get());
  }

  public static CallSimulator_Factory create(
      Provider<CallRecordingController> callRecordingControllerProvider) {
    return new CallSimulator_Factory(callRecordingControllerProvider);
  }

  public static CallSimulator newInstance(CallRecordingController callRecordingController) {
    return new CallSimulator(callRecordingController);
  }
}
