package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IListModelUseCase<ModelTest> {
            override fun invoke(): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }

            override fun invoke(input1: Long, input2: Long): List<ModelTest> {
                throw NotImplementedError()
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit))
    }

    @Test
    fun testInvokeLimitOffset() {
        val useCase = object : IListModelUseCase<ModelTest> {
            override fun invoke(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun invoke(input1: Long, input2: Long): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit))
    }

}
