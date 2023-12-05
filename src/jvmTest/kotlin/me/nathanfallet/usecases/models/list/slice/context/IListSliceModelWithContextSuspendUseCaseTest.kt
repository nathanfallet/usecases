package me.nathanfallet.usecases.models.list.slice.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListSliceModelWithContextSuspendUseCase<ModelTest> {
            override suspend fun invoke(input1: Long, input2: Long, input3: IContext): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        val context = object : IContext {}
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit, context))
    }

}
