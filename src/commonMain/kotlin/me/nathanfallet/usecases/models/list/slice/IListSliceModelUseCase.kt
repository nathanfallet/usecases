package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListSliceModelUseCase<Model : IModel<*, *, *>> : IListSliceChildModelUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: Pagination): List<Model>

    override fun invoke(input1: Pagination, input2: Unit): List<Model> = invoke(input1)

}
