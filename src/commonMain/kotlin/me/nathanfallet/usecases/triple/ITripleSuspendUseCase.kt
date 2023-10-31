package me.nathanfallet.usecases.triple

import me.nathanfallet.usecases.ISuspendUseCase

interface ITripleSuspendUseCase<I, J, K, O>: ISuspendUseCase<Triple<I, J, K>, O> {

    suspend operator fun invoke(input1: I, input2: J, input3: K): O

    override suspend fun invoke(input: Triple<I, J, K>): O {
        return invoke(input.first, input.second, input.third)
    }

}