package com.company.app.domain.usecase.chat;

import com.company.app.domain.repository.ChatRepository;
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
public final class ObserveChatMessagesUseCase_Factory implements Factory<ObserveChatMessagesUseCase> {
  private final Provider<ChatRepository> repositoryProvider;

  public ObserveChatMessagesUseCase_Factory(Provider<ChatRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ObserveChatMessagesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ObserveChatMessagesUseCase_Factory create(
      Provider<ChatRepository> repositoryProvider) {
    return new ObserveChatMessagesUseCase_Factory(repositoryProvider);
  }

  public static ObserveChatMessagesUseCase newInstance(ChatRepository repository) {
    return new ObserveChatMessagesUseCase(repository);
  }
}
