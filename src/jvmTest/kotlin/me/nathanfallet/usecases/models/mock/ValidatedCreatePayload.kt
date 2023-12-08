package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.annotations.validators.StringPropertyValidator

data class ValidatedCreatePayload(
    @StringPropertyValidator(regex = "[a-z]+", minLength = 3, maxLength = 10)
    val name: String,
)
