package me.nathanfallet.usecases.models.create

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateModelFromRepositorySuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val repository = mockk<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = CreateModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.create(CreatePayloadTest("test"), Unit)
        } returns ModelTest(1, "test")
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test")))
    }

}
