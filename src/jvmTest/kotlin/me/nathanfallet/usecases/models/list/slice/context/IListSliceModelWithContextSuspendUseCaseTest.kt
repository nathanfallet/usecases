package me.nathanfallet.usecases.models.list.slice.context

import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelWithContextSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListSliceModelWithContextSuspendUseCase<ModelTest> {
            override suspend fun invoke(input1: Pagination, input2: IContext): List<ModelTest> =
                listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Pagination(1, 0), Unit, mockk()))
    }

}
