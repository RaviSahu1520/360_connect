package com.company.app.domain.usecase.call;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086B\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/company/app/domain/usecase/call/GetCallDetailUseCase;", "", "callRepository", "Lcom/company/app/domain/repository/CallRepository;", "(Lcom/company/app/domain/repository/CallRepository;)V", "invoke", "Lcom/company/app/domain/model/CallWithTranscript;", "callId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetCallDetailUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.domain.repository.CallRepository callRepository = null;
    
    @javax.inject.Inject()
    public GetCallDetailUseCase(@org.jetbrains.annotations.NotNull()
    com.company.app.domain.repository.CallRepository callRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(long callId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.app.domain.model.CallWithTranscript> $completion) {
        return null;
    }
}