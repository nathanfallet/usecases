package me.nathanfallet.usecases.models

@Target(AnnotationTarget.PROPERTY)
annotation class PayloadProperty(
    val type: String,
    val style: String = ""
)
