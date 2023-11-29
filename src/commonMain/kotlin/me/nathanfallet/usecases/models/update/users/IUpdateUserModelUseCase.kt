package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IUpdateUserModelUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IUpdateUserChildModelUseCase<Model, Id, UpdatePayload, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Id, input2: UpdatePayload, input3: IUser): Model?

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IUser): Model? {
        return invoke(input1, input2, input4)
    }

}
