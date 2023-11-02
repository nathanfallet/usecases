package me.nathanfallet.usecases.models.get

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.CreatePayloadTest
import me.nathanfallet.usecases.models.ModelTest
import me.nathanfallet.usecases.models.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = GetModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.get(1)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1))
    }

}