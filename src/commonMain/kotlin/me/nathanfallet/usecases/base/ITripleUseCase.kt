package me.nathanfallet.usecases.base

import kotlin.js.JsExport

@JsExport
interface ITripleUseCase<Input1, Input2, Input3, Output> : IGenericUseCase {

    operator fun invoke(input1: Input1, input2: Input2, input3: Input3): Output

}
