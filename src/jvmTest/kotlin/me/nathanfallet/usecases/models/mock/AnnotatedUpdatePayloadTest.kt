package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.annotations.PayloadProperty

data class AnnotatedUpdatePayloadTest(
    @PayloadProperty("string")
    val value: String
)
