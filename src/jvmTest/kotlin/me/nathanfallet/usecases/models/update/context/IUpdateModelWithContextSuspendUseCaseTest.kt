package me.nathanfallet.usecases.models.update.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IUpdateModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IUpdateModelWithContextSuspendUseCase<ModelTest, Long, UpdatePayloadTest> {
            override suspend fun invoke(input1: Long, input2: UpdatePayloadTest, input3: IContext): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val context = object : IContext {}
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), Unit, context))
    }

}
