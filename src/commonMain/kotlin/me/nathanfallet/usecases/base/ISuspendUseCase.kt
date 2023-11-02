package me.nathanfallet.usecases.base

interface ISuspendUseCase<Input, Output> : IGenericUseCase {

    suspend operator fun invoke(input: Input): Output

}