package me.nathanfallet.usecases.models.annotations.validators

import kotlin.jvm.JvmStatic

object PropertyValidator {

    @JvmStatic
    fun validate(value: Any, validator: Any): Boolean {
        return when (validator) {
            is StringPropertyValidator -> value is String &&
                    value.matches(Regex(validator.regex)) &&
                    value.length >= validator.minLength &&
                    value.length <= validator.maxLength

            else -> true
        }
    }

}
