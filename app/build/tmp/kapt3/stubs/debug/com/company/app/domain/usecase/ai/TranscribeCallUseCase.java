package com.company.app.domain.usecase.ai;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/company/app/domain/usecase/ai/TranscribeCallUseCase;", "", "repository", "Lcom/company/app/domain/repository/AIRepository;", "(Lcom/company/app/domain/repository/AIRepository;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "", "audioPath", "app_debug"})
public final class TranscribeCallUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.repository.AIRepository repository = null;
    
    @javax.inject.Inject()
    public TranscribeCallUseCase(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.AIRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> execute(@org.jetbrains.annotations.NotNull()
    java.lang.String audioPath) {
        return null;
    }
}