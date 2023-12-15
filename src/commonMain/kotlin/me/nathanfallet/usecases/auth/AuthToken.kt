package me.nathanfallet.usecases.auth

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class AuthToken(
    @Schema(name = "Access Token", example = "1234abcd")
    val accessToken: String,
    @Schema(name = "Refresh Token", example = "1234abcd")
    val refreshToken: String? = null,
    @Schema(name = "ID Token", example = "1234abcd")
    val idToken: String? = null,
)
