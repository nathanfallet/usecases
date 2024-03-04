package me.nathanfallet.usecases.models.delete

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class DeleteModelFromRepositorySuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val repository = mockk<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = DeleteModelFromRepositorySuspendUseCase(repository)
        coEvery { repository.delete(1, Unit) } returns true
        assertEquals(true, useCase(1))
    }

}
