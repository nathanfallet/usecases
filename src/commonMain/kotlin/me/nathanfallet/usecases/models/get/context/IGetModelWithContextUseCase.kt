package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IGetModelWithContextUseCase<Model : IModel<Id, *, *>, Id> :
    IGetChildModelWithContextUseCase<Model, Id, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Id, input2: IContext): Model?

    override fun invoke(input1: Id, input2: Unit, input3: IContext): Model? {
        return invoke(input1, input3)
    }

}
