package me.nathanfallet.usecases.models.list.context

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListModelWithContextSuspendUseCase<ModelTest> {
            override suspend fun invoke(input: IContext): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        val context = object : IContext {}
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit, context))
    }

}
