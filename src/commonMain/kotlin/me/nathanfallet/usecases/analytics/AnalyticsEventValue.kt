package me.nathanfallet.usecases.analytics

data class AnalyticsEventValue<T>(val value: T) : IAnalyticsEventValue