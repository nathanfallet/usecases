package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface IChildModelSuspendRepository<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload, UpdatePayload, ParentId> {

    suspend fun list(parentId: ParentId, context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    suspend fun list(limit: Long, offset: Long, parentId: ParentId, context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    suspend fun get(id: Id, parentId: ParentId, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    suspend fun create(payload: CreatePayload, parentId: ParentId, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    suspend fun update(id: Id, payload: UpdatePayload, parentId: ParentId, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }

    suspend fun delete(id: Id, parentId: ParentId, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }

}
