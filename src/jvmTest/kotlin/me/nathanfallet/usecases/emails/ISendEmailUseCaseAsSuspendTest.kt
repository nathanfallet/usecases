package me.nathanfallet.usecases.emails

import io.mockative.*
import kotlinx.coroutines.runBlocking
import kotlin.test.AfterTest
import kotlin.test.Test

class ISendEmailUseCaseAsSuspendTest {

    @Mock
    val useCase = mock(classOf<ISendEmailUseCase>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(useCase)
    }

    @Test
    fun invokeSuspendFromNonSuspend() = runBlocking {
        val email = object : IEmail {}
        val recipients = listOf("recipient")
        val suspendUseCase = ISendEmailUseCaseAsSuspend(useCase)
        suspendUseCase(email, recipients)
        coVerify { useCase(email, recipients) }.wasInvoked()
    }

}
