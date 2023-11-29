package me.nathanfallet.usecases.models.list.slice

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelSuspendUseCaseTest {

    @Test
    fun testInvokeLimitOffset() = runBlocking {
        val useCase = object : IListSliceModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(input1: Long, input2: Long): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit))
    }

}
