package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel

interface IModelRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> {

    fun get(id: Id): Model?
    fun create(payload: CreatePayload): Model?
    fun update(id: Id, payload: UpdatePayload): Boolean
    fun delete(id: Id): Boolean

}
