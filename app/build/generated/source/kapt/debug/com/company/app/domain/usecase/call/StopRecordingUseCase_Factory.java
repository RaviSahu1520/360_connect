package com.company.app.domain.usecase.call;

import com.company.app.platform.recording.CallRecordingController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class StopRecordingUseCase_Factory implements Factory<StopRecordingUseCase> {
  private final Provider<CallRecordingController> callRecordingControllerProvider;

  public StopRecordingUseCase_Factory(
      Provider<CallRecordingController> callRecordingControllerProvider) {
    this.callRecordingControllerProvider = callRecordingControllerProvider;
  }

  @Override
  public StopRecordingUseCase get() {
    return newInstance(callRecordingControllerProvider.get());
  }

  public static StopRecordingUseCase_Factory create(
      Provider<CallRecordingController> callRecordingControllerProvider) {
    return new StopRecordingUseCase_Factory(callRecordingControllerProvider);
  }

  public static StopRecordingUseCase newInstance(CallRecordingController callRecordingController) {
    return new StopRecordingUseCase(callRecordingController);
  }
}
