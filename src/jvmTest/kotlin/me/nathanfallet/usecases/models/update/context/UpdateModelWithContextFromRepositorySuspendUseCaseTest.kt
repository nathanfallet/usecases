package me.nathanfallet.usecases.models.update.context

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateModelWithContextFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = UpdateModelWithContextFromRepositorySuspendUseCase(repository)
        val context = object : IContext {}
        coEvery {
            repository.update(1, UpdatePayloadTest("test"), Unit, context)
        }.returns(true)
        coEvery { repository.get(1, Unit, context) }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), context))
    }

    @Test
    fun testInvokeFails() = runBlocking {
        val useCase = UpdateModelWithContextFromRepositorySuspendUseCase(repository)
        val context = object : IContext {}
        coEvery {
            repository.update(1, UpdatePayloadTest("test"), Unit, context)
        }.returns(false)
        assertEquals(null, useCase(1, UpdatePayloadTest("test"), context))
    }
}
