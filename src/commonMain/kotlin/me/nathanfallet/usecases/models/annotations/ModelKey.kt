package me.nathanfallet.usecases.models.annotations

import kotlinx.serialization.Serializable

@Serializable
data class ModelKey(
    val key: String,
    val type: String,
    val style: String,
)
