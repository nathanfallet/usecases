package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICountModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : ICountModelUseCase<ModelTest> {
            override fun invoke(): Long = 1
        }
        assertEquals(1, useCase(Unit))
    }

}
