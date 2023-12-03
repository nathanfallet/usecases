package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface ICreateModelWithContextUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateChildModelWithContextUseCase<Model, CreatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: CreatePayload, input2: IContext): Model?

    override fun invoke(input1: CreatePayload, input2: Unit, input3: IContext): Model? {
        return invoke(input1, input3)
    }

}
