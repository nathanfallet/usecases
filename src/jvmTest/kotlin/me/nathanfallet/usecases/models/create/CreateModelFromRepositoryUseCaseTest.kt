package me.nathanfallet.usecases.models.create

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = CreateModelFromRepositoryUseCase(repository)
        every {
            repository.create(CreatePayloadTest("test"))
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test")))
    }

}