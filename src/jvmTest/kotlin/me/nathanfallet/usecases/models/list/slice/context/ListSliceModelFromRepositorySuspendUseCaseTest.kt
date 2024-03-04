package me.nathanfallet.usecases.models.list.slice.context

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertEquals

class ListSliceModelFromRepositorySuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val repository = mockk<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = ListSliceModelWithContextFromRepositorySuspendUseCase(repository)
        val context = mockk<IContext>()
        coEvery { repository.list(Pagination(1, 0), Unit, context) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase(Pagination(1, 0), context))
    }

}
