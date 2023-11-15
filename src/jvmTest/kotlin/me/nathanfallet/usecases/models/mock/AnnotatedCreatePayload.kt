package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.annotations.PayloadProperty

data class AnnotatedCreatePayload(
    @PayloadProperty("string")
    val value: String
)
