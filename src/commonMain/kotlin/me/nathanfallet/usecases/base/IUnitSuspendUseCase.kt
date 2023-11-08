package me.nathanfallet.usecases.base

interface IUnitSuspendUseCase<Output> : IGenericUseCase {

    suspend operator fun invoke(): Output

}
