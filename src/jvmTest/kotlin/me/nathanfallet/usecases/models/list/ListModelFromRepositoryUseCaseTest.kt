package me.nathanfallet.usecases.models.list

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class ListModelFromRepositoryUseCaseTest {

    @Test
    fun testInvoke() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = ListModelFromRepositoryUseCase(repository)
        every { repository.list(Unit) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase())
    }

}
