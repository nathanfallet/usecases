package me.nathanfallet.usecases.base

interface IUseCase<Input, Output> : IGenericUseCase {

    operator fun invoke(input: Input): Output

}