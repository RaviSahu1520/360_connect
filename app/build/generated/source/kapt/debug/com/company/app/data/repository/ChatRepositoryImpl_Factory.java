package com.company.app.data.repository;

import com.company.app.core.common.DispatcherProvider;
import com.company.app.core.security.EncryptionManager;
import com.company.app.data.local.dao.MessageDao;
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
public final class ChatRepositoryImpl_Factory implements Factory<ChatRepositoryImpl> {
  private final Provider<MessageDao> messageDaoProvider;

  private final Provider<EncryptionManager> encryptionManagerProvider;

  private final Provider<DispatcherProvider> dispatchersProvider;

  public ChatRepositoryImpl_Factory(Provider<MessageDao> messageDaoProvider,
      Provider<EncryptionManager> encryptionManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    this.messageDaoProvider = messageDaoProvider;
    this.encryptionManagerProvider = encryptionManagerProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public ChatRepositoryImpl get() {
    return newInstance(messageDaoProvider.get(), encryptionManagerProvider.get(), dispatchersProvider.get());
  }

  public static ChatRepositoryImpl_Factory create(Provider<MessageDao> messageDaoProvider,
      Provider<EncryptionManager> encryptionManagerProvider,
      Provider<DispatcherProvider> dispatchersProvider) {
    return new ChatRepositoryImpl_Factory(messageDaoProvider, encryptionManagerProvider, dispatchersProvider);
  }

  public static ChatRepositoryImpl newInstance(MessageDao messageDao,
      EncryptionManager encryptionManager, DispatcherProvider dispatchers) {
    return new ChatRepositoryImpl(messageDao, encryptionManager, dispatchers);
  }
}
