package me.nathanfallet.usecases.models.create

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = CreateModelFromRepositorySuspendUseCase(repository)
        coEvery {
            repository.create(CreatePayloadTest("test"))
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test")))
    }

}