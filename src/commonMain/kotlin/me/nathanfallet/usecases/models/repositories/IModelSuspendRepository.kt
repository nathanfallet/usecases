package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel

interface IModelSuspendRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelSuspendRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    suspend fun list(): List<Model>
    suspend fun list(limit: Long, offset: Long): List<Model>
    suspend fun get(id: Id): Model?
    suspend fun create(payload: CreatePayload): Model?
    suspend fun update(id: Id, payload: UpdatePayload): Boolean
    suspend fun delete(id: Id): Boolean

    override suspend fun list(parentId: Unit): List<Model> {
        return list()
    }

    override suspend fun list(limit: Long, offset: Long, parentId: Unit): List<Model> {
        return list(limit, offset)
    }

    override suspend fun get(id: Id, parentId: Unit): Model? {
        return get(id)
    }

    override suspend fun create(payload: CreatePayload, parentId: Unit): Model? {
        return create(payload)
    }

    override suspend fun update(id: Id, payload: UpdatePayload, parentId: Unit): Boolean {
        return update(id, payload)
    }

    override suspend fun delete(id: Id, parentId: Unit): Boolean {
        return delete(id)
    }

}
