package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface ICreateUserModelUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateUserChildModelUseCase<Model, CreatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: CreatePayload, input2: IUser): Model?

    override fun invoke(input1: CreatePayload, input2: Unit, input3: IUser): Model? {
        return invoke(input1, input3)
    }

}
