package me.nathanfallet.usecases.models

interface IModel<Id, CreatePayload, UpdatePayload> {

    val id: Id

}