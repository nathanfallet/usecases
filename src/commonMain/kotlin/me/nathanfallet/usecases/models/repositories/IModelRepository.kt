package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IModelRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    @JsName("listDefault")
    fun list(): List<Model>

    @JsName("listWithLimitDefault")
    fun list(limit: Long, offset: Long): List<Model>

    @JsName("getDefault")
    fun get(id: Id): Model?

    @JsName("createDefault")
    fun create(payload: CreatePayload, user: IUser? = null): Model?

    @JsName("updateDefault")
    fun update(id: Id, payload: UpdatePayload, user: IUser? = null): Boolean

    @JsName("deleteDefault")
    fun delete(id: Id): Boolean

    override fun list(parentId: Unit): List<Model> {
        return list()
    }

    override fun list(limit: Long, offset: Long, parentId: Unit): List<Model> {
        return list(limit, offset)
    }

    override fun get(id: Id, parentId: Unit): Model? {
        return get(id)
    }

    override fun create(payload: CreatePayload, parentId: Unit, user: IUser?): Model? {
        return create(payload, user)
    }

    override fun update(id: Id, payload: UpdatePayload, parentId: Unit, user: IUser?): Boolean {
        return update(id, payload, user)
    }

    override fun delete(id: Id, parentId: Unit): Boolean {
        return delete(id)
    }

}
