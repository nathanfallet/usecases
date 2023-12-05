package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IModelRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    @JsName("listDefault")
    fun list(context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    @JsName("listWithLimitDefault")
    fun list(limit: Long, offset: Long, context: IContext? = null): List<Model> {
        throw UnsupportedOperationException()
    }

    @JsName("getDefault")
    fun get(id: Id, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    @JsName("createDefault")
    fun create(payload: CreatePayload, context: IContext? = null): Model? {
        throw UnsupportedOperationException()
    }

    @JsName("updateDefault")
    fun update(id: Id, payload: UpdatePayload, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }

    @JsName("deleteDefault")
    fun delete(id: Id, context: IContext? = null): Boolean {
        throw UnsupportedOperationException()
    }

    override fun list(parentId: Unit, context: IContext?): List<Model> {
        return list(context)
    }

    override fun list(limit: Long, offset: Long, parentId: Unit, context: IContext?): List<Model> {
        return list(limit, offset, context)
    }

    override fun get(id: Id, parentId: Unit, context: IContext?): Model? {
        return get(id, context)
    }

    override fun create(payload: CreatePayload, parentId: Unit, context: IContext?): Model? {
        return create(payload, context)
    }

    override fun update(id: Id, payload: UpdatePayload, parentId: Unit, context: IContext?): Boolean {
        return update(id, payload, context)
    }

    override fun delete(id: Id, parentId: Unit, context: IContext?): Boolean {
        return delete(id, context)
    }

}
