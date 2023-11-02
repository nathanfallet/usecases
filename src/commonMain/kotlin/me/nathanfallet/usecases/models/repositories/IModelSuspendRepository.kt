package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel

interface IModelSuspendRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> {

    suspend fun get(id: Id): Model?
    suspend fun create(payload: CreatePayload): Model?
    suspend fun update(id: Id, payload: UpdatePayload): Boolean
    suspend fun delete(id: Id): Boolean

}
