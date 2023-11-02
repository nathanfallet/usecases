package me.nathanfallet.usecases.base

interface IPairSuspendUseCase<Input1, Input2, Output> : ISuspendUseCase<Pair<Input1, Input2>, Output> {

    suspend operator fun invoke(input1: Input1, input2: Input2): Output

    override suspend fun invoke(input: Pair<Input1, Input2>): Output {
        return invoke(input.first, input.second)
    }

}