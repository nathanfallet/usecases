package me.nathanfallet.usecases.analytics

class ILogEventUseCaseAsSuspend(private val useCase: ILogEventUseCase) : ILogEventSuspendUseCase {

    override suspend fun invoke(
        input1: IAnalyticsEventName,
        input2: Map<IAnalyticsEventParameter, IAnalyticsEventValue>
    ) {
        useCase(input1, input2)
    }

}