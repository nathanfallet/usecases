package me.nathanfallet.usecases.analytics

import me.nathanfallet.usecases.base.pair.IPairSuspendUseCase

interface ILogEventSuspendUseCase :
    IPairSuspendUseCase<IAnalyticsEventName, Map<IAnalyticsEventParameter, IAnalyticsEventValue>, Unit>
