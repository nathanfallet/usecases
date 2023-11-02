package me.nathanfallet.usecases.base.triple

import me.nathanfallet.usecases.base.ISuspendUseCase

interface ITripleSuspendUseCase<Input1, Input2, Input3, Output> :
    ISuspendUseCase<Triple<Input1, Input2, Input3>, Output> {

    suspend operator fun invoke(input1: Input1, input2: Input2, input3: Input3): Output

    override suspend fun invoke(input: Triple<Input1, Input2, Input3>): Output {
        return invoke(input.first, input.second, input.third)
    }

}