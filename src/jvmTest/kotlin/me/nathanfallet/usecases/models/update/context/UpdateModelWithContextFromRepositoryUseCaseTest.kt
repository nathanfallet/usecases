package me.nathanfallet.usecases.models.update.context

import io.mockative.*
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateModelWithContextFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = UpdateModelWithContextFromRepositoryUseCase(repository)
        val context = object : IContext {}
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit, context)
        }.returns(true)
        every { repository.get(1, Unit, context) }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), context))
    }

    @Test
    fun testInvokeFails() {
        val useCase = UpdateModelWithContextFromRepositoryUseCase(repository)
        val context = object : IContext {}
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit, context)
        }.returns(false)
        assertEquals(null, useCase(1, UpdatePayloadTest("test"), context))
    }

}
