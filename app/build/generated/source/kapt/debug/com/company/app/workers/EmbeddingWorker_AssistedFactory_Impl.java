package com.company.app.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class EmbeddingWorker_AssistedFactory_Impl implements EmbeddingWorker_AssistedFactory {
  private final EmbeddingWorker_Factory delegateFactory;

  EmbeddingWorker_AssistedFactory_Impl(EmbeddingWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public EmbeddingWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<EmbeddingWorker_AssistedFactory> create(
      EmbeddingWorker_Factory delegateFactory) {
    return InstanceFactory.create(new EmbeddingWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<EmbeddingWorker_AssistedFactory> createFactoryProvider(
      EmbeddingWorker_Factory delegateFactory) {
    return InstanceFactory.create(new EmbeddingWorker_AssistedFactory_Impl(delegateFactory));
  }
}
