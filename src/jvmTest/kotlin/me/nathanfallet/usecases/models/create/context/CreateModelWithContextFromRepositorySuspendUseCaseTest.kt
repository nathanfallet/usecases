package me.nathanfallet.usecases.models.create.context

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

class CreateModelWithContextFromRepositorySuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val repository = mockk<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = CreateModelWithContextFromRepositorySuspendUseCase(repository)
        val context = mockk<IContext>()
        coEvery {
            repository.create(CreatePayloadTest("test"), Unit, context)
        } returns ModelTest(1, "test")
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), context))
    }

}
