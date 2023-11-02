package me.nathanfallet.usecases.base.unit

import kotlin.test.Test
import kotlin.test.assertEquals

class IUnitUseCaseTest {

    @Test
    fun testInvokeWithUnit() {
        val useCase = object : IUnitUseCase<String> {
            override fun invoke(): String {
                return "test"
            }
        }
        assertEquals("test", useCase(Unit))
    }

}