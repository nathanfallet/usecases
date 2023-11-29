package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListModelUseCase<Model : IModel<*, *, *>> : IListChildModelUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(): List<Model>

    override fun invoke(input: Unit): List<Model> {
        return invoke()
    }

}
