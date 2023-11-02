package me.nathanfallet.usecases.models.annotations

import kotlinx.serialization.Serializable

@Serializable
data class PayloadKey(
    val key: String,
    val type: String,
    val style: String,
    val editable: Boolean,
)
