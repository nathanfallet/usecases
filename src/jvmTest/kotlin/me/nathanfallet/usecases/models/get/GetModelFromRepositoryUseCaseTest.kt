package me.nathanfallet.usecases.models.get

import io.mockative.*
import me.nathanfallet.usecases.models.CreatePayloadTest
import me.nathanfallet.usecases.models.ModelTest
import me.nathanfallet.usecases.models.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = GetModelFromRepositoryUseCase(repository)
        every {
            repository.get(1)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1))
    }

}