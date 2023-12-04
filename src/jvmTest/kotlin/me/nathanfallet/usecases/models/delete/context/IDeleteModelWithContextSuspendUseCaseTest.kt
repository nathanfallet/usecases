package me.nathanfallet.usecases.models.delete.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IDeleteModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IDeleteModelWithContextSuspendUseCase<ModelTest, Long> {
            override suspend fun invoke(input1: Long, input2: IContext): Boolean {
                return true
            }
        }
        val context = object : IContext {}
        assertEquals(true, useCase(1, Unit, context))
    }

}
