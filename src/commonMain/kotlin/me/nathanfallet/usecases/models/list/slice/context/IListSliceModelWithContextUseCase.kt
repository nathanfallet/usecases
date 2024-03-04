package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListSliceModelWithContextUseCase<Model : IModel<*, *, *>> :
    IListSliceChildModelWithContextUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Pagination, input2: IContext): List<Model>

    override fun invoke(input1: Pagination, input2: Unit, input3: IContext): List<Model> = invoke(input1, input3)

}
