package com.company.app.presentation.permissions;

import android.content.Context;
import com.company.app.platform.recording.AudioCaptureManager;
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
public final class PermissionsManager_Factory implements Factory<PermissionsManager> {
  private final Provider<Context> contextProvider;

  private final Provider<AudioCaptureManager> audioCaptureManagerProvider;

  public PermissionsManager_Factory(Provider<Context> contextProvider,
      Provider<AudioCaptureManager> audioCaptureManagerProvider) {
    this.contextProvider = contextProvider;
    this.audioCaptureManagerProvider = audioCaptureManagerProvider;
  }

  @Override
  public PermissionsManager get() {
    return newInstance(contextProvider.get(), audioCaptureManagerProvider.get());
  }

  public static PermissionsManager_Factory create(Provider<Context> contextProvider,
      Provider<AudioCaptureManager> audioCaptureManagerProvider) {
    return new PermissionsManager_Factory(contextProvider, audioCaptureManagerProvider);
  }

  public static PermissionsManager newInstance(Context context,
      AudioCaptureManager audioCaptureManager) {
    return new PermissionsManager(context, audioCaptureManager);
  }
}
