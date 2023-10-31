package me.nathanfallet.usecases.triple

import me.nathanfallet.usecases.ISuspendUseCase

interface ITripleSuspendUseCase<I, J, K, O>: ISuspendUseCase<Triple<I, J, K>, O> {

    suspend operator fun invoke(input1: I, input2: J, input3: K): O {
        return invoke(Triple(input1, input2, input3))
    }

}