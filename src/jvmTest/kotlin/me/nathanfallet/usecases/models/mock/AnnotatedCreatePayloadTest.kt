package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.annotations.PayloadProperty

data class AnnotatedCreatePayloadTest(
    @PayloadProperty("string")
    val value: String
)
