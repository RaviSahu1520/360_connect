package com.company.app.domain.usecase.call;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/company/app/domain/usecase/call/ObserveTranscriptUseCase;", "", "repository", "Lcom/company/app/domain/repository/CallRepository;", "(Lcom/company/app/domain/repository/CallRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/company/app/domain/model/Transcript;", "callId", "", "app_debug"})
public final class ObserveTranscriptUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.repository.CallRepository repository = null;
    
    @javax.inject.Inject()
    public ObserveTranscriptUseCase(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.CallRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.company.app.domain.model.Transcript> invoke(long callId) {
        return null;
    }
}