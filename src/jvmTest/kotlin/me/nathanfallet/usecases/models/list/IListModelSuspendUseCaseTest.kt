package me.nathanfallet.usecases.models.list

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }

            override suspend fun invoke(input1: Long, input2: Long): List<ModelTest> {
                throw NotImplementedError()
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit))
    }

    @Test
    fun testInvokeLimitOffset() = runBlocking {
        val useCase = object : IListModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(): List<ModelTest> {
                throw NotImplementedError()
            }

            override suspend fun invoke(input1: Long, input2: Long): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit))
    }

}
