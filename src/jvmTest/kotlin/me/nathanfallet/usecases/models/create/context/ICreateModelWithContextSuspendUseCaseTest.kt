package me.nathanfallet.usecases.models.create.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICreateModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : ICreateModelWithContextSuspendUseCase<ModelTest, CreatePayloadTest> {
            override suspend fun invoke(input1: CreatePayloadTest, input2: IContext): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val context = object : IContext {}
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), Unit, context))
    }

}
