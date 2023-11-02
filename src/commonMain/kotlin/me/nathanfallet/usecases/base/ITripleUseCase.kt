package me.nathanfallet.usecases.base

interface ITripleUseCase<Input1, Input2, Input3, Output> : IUseCase<Triple<Input1, Input2, Input3>, Output> {

    operator fun invoke(input1: Input1, input2: Input2, input3: Input3): Output

    override fun invoke(input: Triple<Input1, Input2, Input3>): Output {
        return invoke(input.first, input.second, input.third)
    }

}