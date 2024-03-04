package me.nathanfallet.usecases.models.list

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
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
        val useCase = ListModelFromRepositorySuspendUseCase(repository)
        coEvery { repository.list(Unit) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase())
    }

}
