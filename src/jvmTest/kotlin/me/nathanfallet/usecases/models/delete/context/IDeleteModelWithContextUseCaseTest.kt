package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IDeleteModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IDeleteModelWithContextUseCase<ModelTest, Long> {
            override fun invoke(input1: Long, input2: IContext): Boolean {
                return true
            }
        }
        val context = object : IContext {}
        assertEquals(true, useCase(1, Unit, context))
    }

}
