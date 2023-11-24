package me.nathanfallet.usecases.analytics

import kotlin.js.JsExport

@JsExport
data class AnalyticsEventName(val name: String) : IAnalyticsEventName
