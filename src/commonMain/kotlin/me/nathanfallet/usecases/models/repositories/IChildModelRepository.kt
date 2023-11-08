package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IChildModel

interface IChildModelRepository<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload, UpdatePayload, ParentId> {

    fun get(id: Id, parentId: ParentId): Model?
    fun create(payload: CreatePayload, parentId: ParentId): Model?
    fun update(id: Id, payload: UpdatePayload, parentId: ParentId): Boolean
    fun delete(id: Id, parentId: ParentId): Boolean

}