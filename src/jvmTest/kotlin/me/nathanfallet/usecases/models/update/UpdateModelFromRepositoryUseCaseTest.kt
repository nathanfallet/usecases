package me.nathanfallet.usecases.models.update

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = UpdateModelFromRepositoryUseCase(repository)
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }.returns(true)
        every {
            repository.get(1, Unit)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test")))
    }

    @Test
    fun testInvokeFails() {
        val useCase = UpdateModelFromRepositoryUseCase(repository)
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }.returns(false)
        assertEquals(null, useCase(1, UpdatePayloadTest("test")))
    }

}