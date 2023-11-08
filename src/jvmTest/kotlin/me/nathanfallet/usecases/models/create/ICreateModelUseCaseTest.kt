package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICreateModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : ICreateModelUseCase<ModelTest, CreatePayloadTest> {
            override fun invoke(input: CreatePayloadTest): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), Unit))
    }

}