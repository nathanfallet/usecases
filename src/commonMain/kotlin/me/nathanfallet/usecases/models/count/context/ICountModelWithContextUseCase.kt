package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface ICountModelWithContextUseCase<Model : IModel<*, *, *>> : ICountChildModelWithContextUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: IContext): Long

    override fun invoke(input1: Unit, input2: IContext): Long = invoke(input2)

}
