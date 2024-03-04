package me.nathanfallet.usecases.models.delete.context

import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IDeleteModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IDeleteModelWithContextSuspendUseCase<ModelTest, Long> {
            override suspend fun invoke(input1: Long, input2: IContext): Boolean = true
        }
        assertEquals(true, useCase(1, Unit, mockk()))
    }

}
