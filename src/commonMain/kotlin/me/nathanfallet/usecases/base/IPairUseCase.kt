package me.nathanfallet.usecases.base

import kotlin.js.JsExport

@JsExport
interface IPairUseCase<Input1, Input2, Output> : IGenericUseCase {

    operator fun invoke(input1: Input1, input2: Input2): Output

}
