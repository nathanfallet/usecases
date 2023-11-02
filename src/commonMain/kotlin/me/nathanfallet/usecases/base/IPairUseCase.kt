package me.nathanfallet.usecases.base

interface IPairUseCase<Input1, Input2, Output> : IUseCase<Pair<Input1, Input2>, Output> {

    operator fun invoke(input1: Input1, input2: Input2): Output

    override fun invoke(input: Pair<Input1, Input2>): Output {
        return invoke(input.first, input.second)
    }

}