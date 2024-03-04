package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListModelWithContextUseCase<Model : IModel<*, *, *>> : IListChildModelWithContextUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: IContext): List<Model>

    override fun invoke(input1: Unit, input2: IContext): List<Model> = invoke(input2)

}
