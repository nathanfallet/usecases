package me.nathanfallet.usecases.models.update

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = UpdateModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }.returns(true)
        coEvery {
            repository.get(1, Unit)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test")))
    }

    @Test
    fun testInvokeFails() = runBlocking {
        val useCase = UpdateModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }.returns(false)
        assertEquals(null, useCase(1, UpdatePayloadTest("test")))
    }

}