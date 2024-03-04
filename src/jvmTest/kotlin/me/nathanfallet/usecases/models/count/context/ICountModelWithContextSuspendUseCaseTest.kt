package me.nathanfallet.usecases.models.count.context

import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICountModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : ICountModelWithContextSuspendUseCase<ModelTest> {
            override suspend fun invoke(input: IContext): Long = 1
        }
        assertEquals(1, useCase(Unit, mockk()))
    }

}
