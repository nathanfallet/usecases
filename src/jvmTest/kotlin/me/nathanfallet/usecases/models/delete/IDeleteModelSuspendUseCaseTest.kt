package me.nathanfallet.usecases.models.delete

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IDeleteModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IDeleteModelSuspendUseCase<ModelTest, Long> {
            override suspend fun invoke(input: Long): Boolean = true
        }
        assertEquals(true, useCase(1, Unit))
    }

}
