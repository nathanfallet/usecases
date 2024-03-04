package me.nathanfallet.usecases.models.get.context

import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IGetModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IGetModelWithContextUseCase<ModelTest, Long> {
            override fun invoke(input1: Long, input2: IContext): ModelTest = ModelTest(1, "test")
        }
        assertEquals(ModelTest(1, "test"), useCase(1, Unit, mockk()))
    }

}
