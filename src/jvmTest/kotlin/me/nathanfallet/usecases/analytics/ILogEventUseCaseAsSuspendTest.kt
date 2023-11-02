package me.nathanfallet.usecases.analytics

import io.mockative.*
import kotlinx.coroutines.runBlocking
import kotlin.test.AfterTest
import kotlin.test.Test

class ILogEventUseCaseAsSuspendTest {

    @Mock
    val useCase = mock(classOf<ILogEventUseCase>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(useCase)
    }

    @Test
    fun invokeSuspendFromNonSuspend() = runBlocking {
        val suspendUseCase = ILogEventUseCaseAsSuspend(useCase)
        suspendUseCase(
            AnalyticsEventName("test"), mapOf(
                AnalyticsEventParameter("test") to AnalyticsEventValue("test")
            )
        )
        coVerify {
            useCase(
                AnalyticsEventName("test"), mapOf(
                    AnalyticsEventParameter("test") to AnalyticsEventValue("test")
                )
            )
        }.wasInvoked()
    }

}