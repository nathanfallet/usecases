package me.nathanfallet.usecases.exceptions

class ICaptureExceptionUseCaseAsSuspend(private val useCase: ICaptureExceptionUseCase) :
    ICaptureExceptionSuspendUseCase {

    override suspend fun invoke(input: Throwable) {
        useCase(input)
    }

}