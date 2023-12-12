package me.nathanfallet.usecases.auth

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class AuthRequest(
    @Schema("Client ID", "1234abcd")
    val clientId: String,
    @Schema("Client Secret", "1234abcd")
    val clientSecret: String,
    @Schema("Code", "1234abcd")
    val code: String,
    @Schema("Code Verifier", "1234abcd")
    val codeVerifier: String? = null,
)
