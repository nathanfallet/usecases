package me.nathanfallet.usecases.models.create

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICreateModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : ICreateModelSuspendUseCase<ModelTest, CreatePayloadTest> {
            override suspend fun invoke(input: CreatePayloadTest): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), Unit))
    }

}