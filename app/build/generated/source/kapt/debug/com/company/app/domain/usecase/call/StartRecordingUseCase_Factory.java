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
public final class StartRecordingUseCase_Factory implements Factory<StartRecordingUseCase> {
  private final Provider<CallRecordingController> callRecordingControllerProvider;

  public StartRecordingUseCase_Factory(
      Provider<CallRecordingController> callRecordingControllerProvider) {
    this.callRecordingControllerProvider = callRecordingControllerProvider;
  }

  @Override
  public StartRecordingUseCase get() {
    return newInstance(callRecordingControllerProvider.get());
  }

  public static StartRecordingUseCase_Factory create(
      Provider<CallRecordingController> callRecordingControllerProvider) {
    return new StartRecordingUseCase_Factory(callRecordingControllerProvider);
  }

  public static StartRecordingUseCase newInstance(CallRecordingController callRecordingController) {
    return new StartRecordingUseCase(callRecordingController);
  }
}
