package me.nathanfallet.usecases.pair

import me.nathanfallet.usecases.IUseCase

interface IPairUseCase<I, J, O>: IUseCase<Pair<I, J>, O> {

    operator fun invoke(input1: I, input2: J): O {
        return invoke(Pair(input1, input2))
    }

}