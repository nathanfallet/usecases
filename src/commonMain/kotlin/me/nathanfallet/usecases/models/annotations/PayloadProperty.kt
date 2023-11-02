package me.nathanfallet.usecases.models.annotations

@Target(AnnotationTarget.PROPERTY)
annotation class PayloadProperty(
    val type: String,
    val style: String = ""
)
