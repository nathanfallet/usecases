package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IGetModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IGetModelUseCase<ModelTest, Long> {
            override fun invoke(input: Long): ModelTest = ModelTest(1, "test")
        }
        assertEquals(ModelTest(1, "test"), useCase(1, Unit))
    }

}
