package com.company.app.platform.call;

import com.company.app.data.remote.SignalingClient;
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
public final class VoipSignalingService_MembersInjector implements MembersInjector<VoipSignalingService> {
  private final Provider<SignalingClient> signalingClientProvider;

  public VoipSignalingService_MembersInjector(Provider<SignalingClient> signalingClientProvider) {
    this.signalingClientProvider = signalingClientProvider;
  }

  public static MembersInjector<VoipSignalingService> create(
      Provider<SignalingClient> signalingClientProvider) {
    return new VoipSignalingService_MembersInjector(signalingClientProvider);
  }

  @Override
  public void injectMembers(VoipSignalingService instance) {
    injectSignalingClient(instance, signalingClientProvider.get());
  }

  @InjectedFieldSignature("com.company.app.platform.call.VoipSignalingService.signalingClient")
  public static void injectSignalingClient(VoipSignalingService instance,
      SignalingClient signalingClient) {
    instance.signalingClient = signalingClient;
  }
}
