package me.nathanfallet.usecases.models.list.context

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class ListModelFromRepositorySuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val repository = mockk<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = ListModelWithContextFromRepositorySuspendUseCase(repository)
        val context = mockk<IContext>()
        coEvery { repository.list(Unit, context) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase(context))
    }

}
