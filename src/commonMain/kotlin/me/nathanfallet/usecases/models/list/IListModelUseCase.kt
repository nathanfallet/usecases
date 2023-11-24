package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListModelUseCase<Model : IModel<*, *, *>> : IListChildModelUseCase<Model, Unit> {

    @JsName("invokeDefaultNoRange")
    operator fun invoke(): List<Model>

    @JsName("invokeDefault")
    operator fun invoke(input1: Long, input2: Long): List<Model>

    override fun invoke(input: Unit): List<Model> {
        return invoke()
    }

    override fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return invoke(input1, input2)
    }

}
