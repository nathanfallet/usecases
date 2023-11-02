package me.nathanfallet.usecases.models

@Target(AnnotationTarget.PROPERTY)
annotation class ModelProperty(
    val type: String,
    val style: String = "",
    val visibleOnUpdate: Boolean = false,
)
