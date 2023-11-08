package me.nathanfallet.usecases.models.get

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IGetModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IGetModelSuspendUseCase<ModelTest, Long> {
            override suspend fun invoke(input: Long): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(ModelTest(1, "test"), useCase(1, Unit))
    }

}