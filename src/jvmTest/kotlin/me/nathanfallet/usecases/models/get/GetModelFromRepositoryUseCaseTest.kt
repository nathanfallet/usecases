package me.nathanfallet.usecases.models.get

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class GetModelFromRepositoryUseCaseTest {

    @Test
    fun testInvoke() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = GetModelFromRepositoryUseCase(repository)
        every { repository.get(1, Unit) } returns ModelTest(1, "test")
        assertEquals(ModelTest(1, "test"), useCase(1))
    }

}
