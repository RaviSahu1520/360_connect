package com.company.app.data.repository;

import com.company.app.core.common.DispatcherProvider;
import com.company.app.core.security.EncryptionManager;
import com.company.app.data.local.dao.CallDao;
import com.company.app.data.local.dao.TranscriptDao;
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
public final class CallRepositoryImpl_Factory implements Factory<CallRepositoryImpl> {
  private final Provider<CallDao> callDaoProvider;

  private final Provider<TranscriptDao> transcriptDaoProvider;

  private final Provider<EncryptionManager> encryptionManagerProvider;

  private final Provider<DispatcherProvider> dispatchersProvider;

  public CallRepositoryImpl_Factory(Provider<CallDao> callDaoProvider,
      Provider<TranscriptDao> transcriptDaoProvider,
      Provider<EncryptionManager> encryptionManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    this.callDaoProvider = callDaoProvider;
    this.transcriptDaoProvider = transcriptDaoProvider;
    this.encryptionManagerProvider = encryptionManagerProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public CallRepositoryImpl get() {
    return newInstance(callDaoProvider.get(), transcriptDaoProvider.get(), encryptionManagerProvider.get(), dispatchersProvider.get());
  }

  public static CallRepositoryImpl_Factory create(Provider<CallDao> callDaoProvider,
      Provider<TranscriptDao> transcriptDaoProvider,
      Provider<EncryptionManager> encryptionManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    return new CallRepositoryImpl_Factory(callDaoProvider, transcriptDaoProvider, encryptionManagerProvider, dispatchersProvider);
  }

  public static CallRepositoryImpl newInstance(CallDao callDao, TranscriptDao transcriptDao,
      EncryptionManager encryptionManager, DispatcherProvider dispatchers) {
    return new CallRepositoryImpl(callDao, transcriptDao, encryptionManager, dispatchers);
  }
}
