package me.nathanfallet.usecases.models.list.slice

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelSuspendUseCaseTest {

    @Test
    fun testInvokeLimitOffset() = runBlocking {
        val useCase = object : IListSliceModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(input: Pagination): List<ModelTest> = listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Pagination(1, 0), Unit))
    }

}
