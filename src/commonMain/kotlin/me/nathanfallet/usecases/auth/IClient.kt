package me.nathanfallet.usecases.auth

interface IClient {

    val clientId: String
    val clientSecret: String
    val redirectUri: String

}
