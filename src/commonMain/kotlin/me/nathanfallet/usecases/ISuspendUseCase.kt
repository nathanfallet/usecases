package me.nathanfallet.usecases

interface ISuspendUseCase<I, O>: IGenericUseCase {

    suspend operator fun invoke(input: I): O

}