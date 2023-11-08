package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IDeleteModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IDeleteModelUseCase<ModelTest, Long> {
            override fun invoke(input: Long): Boolean {
                return true
            }
        }
        assertEquals(true, useCase(1, Unit))
    }

}