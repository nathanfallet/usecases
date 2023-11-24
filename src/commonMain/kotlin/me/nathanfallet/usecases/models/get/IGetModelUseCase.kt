package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IGetModelUseCase<Model : IModel<Id, *, *>, Id> : IGetChildModelUseCase<Model, Id, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: Id): Model?

    override fun invoke(input1: Id, input2: Unit): Model? {
        return invoke(input1)
    }

}
