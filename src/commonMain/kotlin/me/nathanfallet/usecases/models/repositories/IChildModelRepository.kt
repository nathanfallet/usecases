package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IChildModelRepository<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload, UpdatePayload, ParentId> {

    fun list(parentId: ParentId): List<Model>

    @JsName("listWithLimit")
    fun list(limit: Long, offset: Long, parentId: ParentId): List<Model>

    fun get(id: Id, parentId: ParentId): Model?
    fun create(payload: CreatePayload, parentId: ParentId, user: IUser? = null): Model?
    fun update(id: Id, payload: UpdatePayload, parentId: ParentId, user: IUser? = null): Boolean
    fun delete(id: Id, parentId: ParentId): Boolean

}
