package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListSliceModelUseCase<Model : IModel<*, *, *>> : IListSliceChildModelUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Long, input2: Long): List<Model>

    override fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return invoke(input1, input2)
    }

}
