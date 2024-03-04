package me.nathanfallet.usecases.models.update

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IUpdateModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IUpdateModelSuspendUseCase<ModelTest, Long, UpdatePayloadTest> {
            override suspend fun invoke(input1: Long, input2: UpdatePayloadTest): ModelTest = ModelTest(1, "test")
        }
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), Unit))
    }

}
