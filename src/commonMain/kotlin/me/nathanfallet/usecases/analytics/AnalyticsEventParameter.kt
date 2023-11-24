package me.nathanfallet.usecases.analytics

import kotlin.js.JsExport

@JsExport
data class AnalyticsEventParameter(val key: String) : IAnalyticsEventParameter
