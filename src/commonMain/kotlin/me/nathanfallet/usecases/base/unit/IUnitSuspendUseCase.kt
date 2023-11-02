package me.nathanfallet.usecases.base.unit

import me.nathanfallet.usecases.base.ISuspendUseCase

interface IUnitSuspendUseCase<Output> : ISuspendUseCase<Unit, Output> {

    suspend operator fun invoke(): Output

    override suspend fun invoke(input: Unit): Output {
        return invoke()
    }

}
