package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IUpdateModelUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IUpdateChildModelUseCase<Model, Id, UpdatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Id, input2: UpdatePayload): Model?

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit): Model? {
        return invoke(input1, input2)
    }

}
