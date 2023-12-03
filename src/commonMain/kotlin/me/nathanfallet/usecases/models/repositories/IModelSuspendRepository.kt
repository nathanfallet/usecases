package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface IModelSuspendRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelSuspendRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    suspend fun list(context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    suspend fun list(limit: Long, offset: Long, context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    suspend fun get(id: Id, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    suspend fun create(payload: CreatePayload, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    suspend fun update(id: Id, payload: UpdatePayload, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }

    suspend fun delete(id: Id, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }


    override suspend fun list(parentId: Unit, context: IContext?): List<Model> {
        return list(context)
    }

    override suspend fun list(limit: Long, offset: Long, parentId: Unit, context: IContext?): List<Model> {
        return list(limit, offset, context)
    }

    override suspend fun get(id: Id, parentId: Unit, context: IContext?): Model? {
        return get(id, context)
    }

    override suspend fun create(payload: CreatePayload, parentId: Unit, context: IContext?): Model? {
        return create(payload, context)
    }

    override suspend fun update(id: Id, payload: UpdatePayload, parentId: Unit, context: IContext?): Boolean {
        return update(id, payload, context)
    }

    override suspend fun delete(id: Id, parentId: Unit, context: IContext?): Boolean {
        return delete(id, context)
    }

}
