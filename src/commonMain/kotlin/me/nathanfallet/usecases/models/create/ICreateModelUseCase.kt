package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface ICreateModelUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateChildModelUseCase<Model, CreatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input: CreatePayload): Model?

    override fun invoke(input1: CreatePayload, input2: Unit): Model? = invoke(input1)

}
