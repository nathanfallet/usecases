package me.nathanfallet.usecases.models.update.context

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateModelWithContextFromRepositoryUseCaseTest {

    @Test
    fun testInvoke() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = UpdateModelWithContextFromRepositoryUseCase(repository)
        val context = mockk<IContext>()
        every { repository.update(1, UpdatePayloadTest("test"), Unit, context) } returns true
        every { repository.get(1, Unit, context) } returns ModelTest(1, "test")
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), context))
    }

    @Test
    fun testInvokeFails() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = UpdateModelWithContextFromRepositoryUseCase(repository)
        val context = mockk<IContext>()
        every { repository.update(1, UpdatePayloadTest("test"), Unit, context) } returns false
        assertEquals(null, useCase(1, UpdatePayloadTest("test"), context))
    }

}
