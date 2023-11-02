package me.nathanfallet.usecases.base.unit

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class IUnitSuspendUseCaseTest {

    @Test
    fun testInvokeWithUnit() = runBlocking {
        val useCase = object : IUnitSuspendUseCase<String> {
            override suspend fun invoke(): String {
                return "test"
            }
        }
        assertEquals("test", useCase(Unit))
    }

}