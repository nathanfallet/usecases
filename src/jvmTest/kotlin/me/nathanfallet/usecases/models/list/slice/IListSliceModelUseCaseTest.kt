package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelUseCaseTest {

    @Test
    fun testInvokeLimitOffset() {
        val useCase = object : IListSliceModelUseCase<ModelTest> {
            override fun invoke(input1: Long, input2: Long): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0, Unit))
    }

}
