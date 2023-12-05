package me.nathanfallet.usecases.models.get.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IGetModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IGetModelWithContextSuspendUseCase<ModelTest, Long> {
            override suspend fun invoke(input1: Long, input2: IContext): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val context = object : IContext {}
        assertEquals(ModelTest(1, "test"), useCase(1, Unit, context))
    }

}
