package me.nathanfallet.usecases.pair

import me.nathanfallet.usecases.IUseCase

interface IPairUseCase<I, J, O>: IUseCase<Pair<I, J>, O> {

    operator fun invoke(input1: I, input2: J): O

    override fun invoke(input: Pair<I, J>): O {
        return invoke(input.first, input.second)
    }

}