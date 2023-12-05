package me.nathanfallet.usecases.models.list.context

import io.mockative.*
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = ListModelWithContextFromRepositoryUseCase(repository)
        val context = object : IContext {}
        every {
            repository.list(Unit, context)
        }.returns(listOf(ModelTest(1, "test")))
        assertEquals(listOf(ModelTest(1, "test")), useCase(context))
    }

}
