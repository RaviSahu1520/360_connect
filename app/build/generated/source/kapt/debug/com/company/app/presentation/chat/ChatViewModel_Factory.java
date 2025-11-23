package com.company.app.presentation.chat;

import androidx.lifecycle.SavedStateHandle;
import com.company.app.domain.usecase.chat.ObserveChatMessagesUseCase;
import com.company.app.domain.usecase.chat.SendMessageUseCase;
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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<ObserveChatMessagesUseCase> observeChatMessagesUseCaseProvider;

  private final Provider<SendMessageUseCase> sendMessageUseCaseProvider;

  public ChatViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<ObserveChatMessagesUseCase> observeChatMessagesUseCaseProvider,
      Provider<SendMessageUseCase> sendMessageUseCaseProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.observeChatMessagesUseCaseProvider = observeChatMessagesUseCaseProvider;
    this.sendMessageUseCaseProvider = sendMessageUseCaseProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(savedStateHandleProvider.get(), observeChatMessagesUseCaseProvider.get(), sendMessageUseCaseProvider.get());
  }

  public static ChatViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<ObserveChatMessagesUseCase> observeChatMessagesUseCaseProvider,
      Provider<SendMessageUseCase> sendMessageUseCaseProvider) {
    return new ChatViewModel_Factory(savedStateHandleProvider, observeChatMessagesUseCaseProvider, sendMessageUseCaseProvider);
  }

  public static ChatViewModel newInstance(SavedStateHandle savedStateHandle,
      ObserveChatMessagesUseCase observeChatMessagesUseCase,
      SendMessageUseCase sendMessageUseCase) {
    return new ChatViewModel(savedStateHandle, observeChatMessagesUseCase, sendMessageUseCase);
  }
}
