package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IListModelWithContextUseCase<ModelTest> {
            override fun invoke(input: IContext): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        val context = object : IContext {}
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit, context))
    }

}
