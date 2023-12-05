package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IGetModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IGetModelWithContextUseCase<ModelTest, Long> {
            override fun invoke(input1: Long, input2: IContext): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val context = object : IContext {}
        assertEquals(ModelTest(1, "test"), useCase(1, Unit, context))
    }

}
