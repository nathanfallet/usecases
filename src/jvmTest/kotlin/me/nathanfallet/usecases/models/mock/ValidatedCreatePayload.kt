package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.annotations.validators.StringPropertyValidator

data class ValidatedCreatePayload(
    @StringPropertyValidator(minLength = 3)
    val name: String,
)
