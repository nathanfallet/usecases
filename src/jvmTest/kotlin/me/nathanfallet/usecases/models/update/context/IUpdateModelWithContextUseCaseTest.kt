package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IUpdateModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IUpdateModelWithContextUseCase<ModelTest, Long, UpdatePayloadTest> {
            override fun invoke(input1: Long, input2: UpdatePayloadTest, input3: IContext): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val context = object : IContext {}
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), Unit, context))
    }

}
