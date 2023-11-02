package me.nathanfallet.usecases.analytics

import me.nathanfallet.usecases.base.pair.IPairUseCase

interface ILogEventUseCase :
    IPairUseCase<IAnalyticsEventName, Map<IAnalyticsEventParameter, IAnalyticsEventValue>, Unit>
