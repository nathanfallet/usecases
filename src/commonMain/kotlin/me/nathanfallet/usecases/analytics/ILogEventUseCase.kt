package me.nathanfallet.usecases.analytics

import me.nathanfallet.usecases.base.IPairUseCase
import kotlin.js.JsExport

@JsExport
interface ILogEventUseCase :
    IPairUseCase<IAnalyticsEventName, Map<IAnalyticsEventParameter, IAnalyticsEventValue>, Unit>
