package me.nathanfallet.usecases.base

import kotlin.js.JsExport

@JsExport
interface IUnitUseCase<Output> : IGenericUseCase {

    operator fun invoke(): Output

}
