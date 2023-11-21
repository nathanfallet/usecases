package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.IModel

interface IModelRepository<Model : IModel<Id, CreatePayload, UpdatePayload>, Id, CreatePayload, UpdatePayload> :
    IChildModelRepository<Model, Id, CreatePayload, UpdatePayload, Unit> {

    fun list(): List<Model>
    fun list(limit: Long, offset: Long): List<Model>
    fun get(id: Id): Model?
    fun create(payload: CreatePayload): Model?
    fun update(id: Id, payload: UpdatePayload): Boolean
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

    override fun create(payload: CreatePayload, parentId: Unit): Model? {
        return create(payload)
    }

    override fun update(id: Id, payload: UpdatePayload, parentId: Unit): Boolean {
        return update(id, payload)
    }

    override fun delete(id: Id, parentId: Unit): Boolean {
        return delete(id)
    }

}
