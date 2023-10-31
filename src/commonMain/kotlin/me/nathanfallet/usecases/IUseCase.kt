package me.nathanfallet.usecases

interface IUseCase<I, O>: IGenericUseCase {

    operator fun invoke(input: I): O

}