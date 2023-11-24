package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IDeleteModelUseCase<Model : IModel<Id, *, *>, Id> : IDeleteChildModelUseCase<Model, Id, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: Id): Boolean

    override fun invoke(input1: Id, input2: Unit): Boolean {
        return invoke(input1)
    }

}
