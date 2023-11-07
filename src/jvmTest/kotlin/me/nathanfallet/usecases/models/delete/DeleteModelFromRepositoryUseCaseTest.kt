package me.nathanfallet.usecases.models.delete

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DeleteModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = DeleteModelFromRepositoryUseCase(repository)
        every {
            repository.delete(1)
        }.returns(true)
        assertEquals(true, useCase(1))
    }

}