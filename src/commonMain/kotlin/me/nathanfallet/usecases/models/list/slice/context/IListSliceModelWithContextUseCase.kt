package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListSliceModelWithContextUseCase<Model : IModel<*, *, *>> :
    IListSliceChildModelWithContextUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Long, input2: Long, input3: IContext): List<Model>

    override fun invoke(input1: Long, input2: Long, input3: Unit, input4: IContext): List<Model> {
        return invoke(input1, input2, input4)
    }

}
