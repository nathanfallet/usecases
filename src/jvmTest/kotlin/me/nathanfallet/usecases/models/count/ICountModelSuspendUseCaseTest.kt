package me.nathanfallet.usecases.models.count

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICountModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : ICountModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(): Long = 1
        }
        assertEquals(1, useCase(Unit))
    }

}
