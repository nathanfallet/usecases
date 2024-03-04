package me.nathanfallet.usecases.models.list.slice.context

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertEquals

class ListSliceModelFromRepositoryUseCaseTest {

    @Test
    fun testInvoke() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = ListSliceModelWithContextFromRepositoryUseCase(repository)
        val context = mockk<IContext>()
        every { repository.list(Pagination(1, 0), Unit, context) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase(Pagination(1, 0), context))
    }

}
