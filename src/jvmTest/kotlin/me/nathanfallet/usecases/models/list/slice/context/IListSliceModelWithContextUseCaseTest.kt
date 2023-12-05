package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IListSliceModelWithContextUseCase<ModelTest> {
            override fun invoke(input1: Long, input2: Long, input3: IContext): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        val context = object : IContext {}
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit, context))
    }

}
