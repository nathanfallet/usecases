package me.nathanfallet.usecases.analytics

import me.nathanfallet.usecases.base.IPairUseCase

interface ILogEventUseCase :
    IPairUseCase<IAnalyticsEventName, Map<IAnalyticsEventParameter, IAnalyticsEventValue>, Unit>
