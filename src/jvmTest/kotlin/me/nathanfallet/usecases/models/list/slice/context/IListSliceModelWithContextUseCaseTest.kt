package me.nathanfallet.usecases.models.list.slice.context

import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertEquals

class IListSliceModelWithContextUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IListSliceModelWithContextUseCase<ModelTest> {
            override fun invoke(input1: Pagination, input2: IContext): List<ModelTest> = listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Pagination(1, 0), Unit, mockk()))
    }

}
