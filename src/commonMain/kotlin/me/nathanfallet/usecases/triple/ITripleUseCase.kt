package me.nathanfallet.usecases.triple

import me.nathanfallet.usecases.IUseCase

interface ITripleUseCase<I, J, K, O>: IUseCase<Triple<I, J, K>, O> {

    operator fun invoke(input1: I, input2: J, input3: K): O

    override fun invoke(input: Triple<I, J, K>): O {
        return invoke(input.first, input.second, input.third)
    }

}