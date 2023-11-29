package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser

interface IChildModelSuspendRepository<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload, UpdatePayload, ParentId> {

    suspend fun list(parentId: ParentId): List<Model>
    suspend fun list(limit: Long, offset: Long, parentId: ParentId): List<Model>
    suspend fun get(id: Id, parentId: ParentId): Model?
    suspend fun create(payload: CreatePayload, parentId: ParentId, user: IUser? = null): Model?
    suspend fun update(id: Id, payload: UpdatePayload, parentId: ParentId, user: IUser? = null): Boolean
    suspend fun delete(id: Id, parentId: ParentId): Boolean

}
