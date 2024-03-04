package me.nathanfallet.usecases.models.list.context

import io.mockk.every
import io.mockk.mockk
import me.nathanfallet.usecases.context.IContext
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
        val useCase = ListModelWithContextFromRepositoryUseCase(repository)
        val context = mockk<IContext>()
        every { repository.list(Unit, context) } returns listOf(ModelTest(1, "test"))
        assertEquals(listOf(ModelTest(1, "test")), useCase(context))
    }

}
