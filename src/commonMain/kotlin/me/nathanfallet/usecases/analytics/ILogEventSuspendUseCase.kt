package me.nathanfallet.usecases.analytics

import me.nathanfallet.usecases.base.IPairSuspendUseCase

interface ILogEventSuspendUseCase :
    IPairSuspendUseCase<IAnalyticsEventName, Map<IAnalyticsEventParameter, IAnalyticsEventValue>, Unit>
