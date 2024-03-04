package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface ICountModelUseCase<Model : IModel<*, *, *>> : ICountChildModelUseCase<Model, Unit> {

    @JsName("invokeDefault")
    operator fun invoke(): Long

    override fun invoke(input: Unit): Long = invoke()

}
