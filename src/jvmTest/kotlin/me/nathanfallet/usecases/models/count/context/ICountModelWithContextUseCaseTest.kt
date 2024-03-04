package me.nathanfallet.usecases.models.count.context

import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICountModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : ICountModelWithContextUseCase<ModelTest> {
            override fun invoke(input: IContext): Long = 1
        }
        assertEquals(1, useCase(Unit, mockk()))
    }

}
