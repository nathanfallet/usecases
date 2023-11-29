package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser

interface IModelSuspendRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelSuspendRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    suspend fun list(): List<Model>
    suspend fun list(limit: Long, offset: Long): List<Model>
    suspend fun get(id: Id): Model?
    suspend fun create(payload: CreatePayload, user: IUser? = null): Model?
    suspend fun update(id: Id, payload: UpdatePayload, user: IUser? = null): Boolean
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

    override suspend fun create(payload: CreatePayload, parentId: Unit, user: IUser?): Model? {
        return create(payload, user)
    }

    override suspend fun update(id: Id, payload: UpdatePayload, parentId: Unit, user: IUser?): Boolean {
        return update(id, payload, user)
    }

    override suspend fun delete(id: Id, parentId: Unit): Boolean {
        return delete(id)
    }

}
