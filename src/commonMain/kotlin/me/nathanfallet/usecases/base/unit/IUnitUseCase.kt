package me.nathanfallet.usecases.base.unit

import me.nathanfallet.usecases.base.IUseCase

interface IUnitUseCase<Output> : IUseCase<Unit, Output> {

    operator fun invoke(): Output

    override fun invoke(input: Unit): Output {
        return invoke()
    }

}