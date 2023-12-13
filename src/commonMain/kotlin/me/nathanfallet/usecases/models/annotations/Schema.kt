package me.nathanfallet.usecases.models.annotations

@Target(AnnotationTarget.PROPERTY)
annotation class Schema(
    val name: String,
    val example: String = "",
)
