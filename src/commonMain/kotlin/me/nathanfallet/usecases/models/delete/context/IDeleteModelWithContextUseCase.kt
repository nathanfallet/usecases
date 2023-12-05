package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IDeleteModelWithContextUseCase<Model : IModel<Id, *, *>, Id> :
    IDeleteChildModelWithContextUseCase<Model, Id, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(input1: Id, input2: IContext): Boolean

    override fun invoke(input1: Id, input2: Unit, input3: IContext): Boolean {
        return invoke(input1, input3)
    }

}
