package me.nathanfallet.usecases.models.create.context

import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICreateModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : ICreateModelWithContextUseCase<ModelTest, CreatePayloadTest> {
            override fun invoke(input1: CreatePayloadTest, input2: IContext): ModelTest = ModelTest(1, "test")
        }
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), Unit, mockk()))
    }

}
