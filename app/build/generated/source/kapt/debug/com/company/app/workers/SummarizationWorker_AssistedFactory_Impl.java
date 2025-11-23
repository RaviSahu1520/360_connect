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
public final class SummarizationWorker_AssistedFactory_Impl implements SummarizationWorker_AssistedFactory {
  private final SummarizationWorker_Factory delegateFactory;

  SummarizationWorker_AssistedFactory_Impl(SummarizationWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public SummarizationWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<SummarizationWorker_AssistedFactory> create(
      SummarizationWorker_Factory delegateFactory) {
    return InstanceFactory.create(new SummarizationWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<SummarizationWorker_AssistedFactory> createFactoryProvider(
      SummarizationWorker_Factory delegateFactory) {
    return InstanceFactory.create(new SummarizationWorker_AssistedFactory_Impl(delegateFactory));
  }
}
