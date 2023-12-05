package me.nathanfallet.usecases.models.list.context

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = ListModelWithContextFromRepositorySuspendUseCase(repository)
        val context = object : IContext {}
        coEvery {
            repository.list(Unit, context)
        }.returns(listOf(ModelTest(1, "test")))
        assertEquals(listOf(ModelTest(1, "test")), useCase(context))
    }

}
