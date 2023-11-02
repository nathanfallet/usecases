package me.nathanfallet.usecases.exceptions

import io.mockative.*
import kotlinx.coroutines.runBlocking
import kotlin.test.AfterTest
import kotlin.test.Test

class ICaptureExceptionUseCaseAsSuspendTest {

    @Mock
    val useCase = mock(classOf<ICaptureExceptionUseCase>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(useCase)
    }

    @Test
    fun invokeSuspendFromNonSuspend() = runBlocking {
        val suspendUseCase = ICaptureExceptionUseCaseAsSuspend(useCase)
        val exception = Exception("test")
        suspendUseCase(exception)
        coVerify {
            useCase(exception)
        }.wasInvoked()
    }

}