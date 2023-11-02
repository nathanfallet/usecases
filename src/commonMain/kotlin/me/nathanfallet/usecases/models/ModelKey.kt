package me.nathanfallet.usecases.models

import kotlinx.serialization.Serializable

@Serializable
data class ModelKey(
    val key: String,
    val type: String,
    val style: String,
)
