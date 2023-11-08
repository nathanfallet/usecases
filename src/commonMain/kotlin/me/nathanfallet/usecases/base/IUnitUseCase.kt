package me.nathanfallet.usecases.base

interface IUnitUseCase<Output> : IGenericUseCase {

    operator fun invoke(): Output

}