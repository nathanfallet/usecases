package me.nathanfallet.usecases.pair

import me.nathanfallet.usecases.ISuspendUseCase

interface IPairSuspendUseCase<I, J, O>: ISuspendUseCase<Pair<I, J>, O> {

    suspend operator fun invoke(input1: I, input2: J): O

    override suspend fun invoke(input: Pair<I, J>): O {
        return invoke(input.first, input.second)
    }

}