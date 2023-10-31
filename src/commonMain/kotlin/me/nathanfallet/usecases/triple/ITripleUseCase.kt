package me.nathanfallet.usecases.triple

import me.nathanfallet.usecases.IUseCase

interface ITripleUseCase<I, J, K, O>: IUseCase<Triple<I, J, K>, O> {

    operator fun invoke(input1: I, input2: J, input3: K): O {
        return invoke(Triple(input1, input2, input3))
    }

}