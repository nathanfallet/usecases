package me.nathanfallet.usecases.models.count.context

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class CountModelFromRepositoryUseCaseTest {

    @Test
    fun testInvoke() {
        val repository = mockk<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>()
        val useCase = CountModelWithContextFromRepositoryUseCase(repository)
        val context = mockk<IContext>()
        every { repository.count(Unit, context) } returns 1
        assertEquals(1, useCase(context))
    }

}
