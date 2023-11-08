package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IChildModel

interface IChildModelSuspendRepository<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload, UpdatePayload, ParentId> {

    suspend fun get(id: Id, parentId: ParentId): Model?
    suspend fun create(payload: CreatePayload, parentId: ParentId): Model?
    suspend fun update(id: Id, payload: UpdatePayload, parentId: ParentId): Boolean
    suspend fun delete(id: Id, parentId: ParentId): Boolean

}