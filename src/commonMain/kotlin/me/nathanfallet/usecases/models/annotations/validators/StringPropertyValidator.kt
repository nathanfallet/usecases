package me.nathanfallet.usecases.models.annotations.validators

@Target(AnnotationTarget.PROPERTY)
annotation class StringPropertyValidator(
    val regex: String = ".*",
    val minLength: Int = 0,
    val maxLength: Int = Int.MAX_VALUE,
)
