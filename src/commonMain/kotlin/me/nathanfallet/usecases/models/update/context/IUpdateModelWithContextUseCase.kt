package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IUpdateModelWithContextUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IUpdateChildModelWithContextUseCase<Model, Id, UpdatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Id, input2: UpdatePayload, input3: IContext): Model?

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IContext): Model? {
        return invoke(input1, input2, input4)
    }

}
