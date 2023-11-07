package me.nathanfallet.usecases.models.delete

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DeleteModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = DeleteModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.delete(1)
        }.returns(true)
        assertEquals(true, useCase(1))
    }

}