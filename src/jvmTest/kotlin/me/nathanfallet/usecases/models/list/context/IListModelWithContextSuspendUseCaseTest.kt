package me.nathanfallet.usecases.models.list.context

import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListModelWithContextSuspendUseCase<ModelTest> {
            override suspend fun invoke(input: IContext): List<ModelTest> = listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit, mockk()))
    }

}
