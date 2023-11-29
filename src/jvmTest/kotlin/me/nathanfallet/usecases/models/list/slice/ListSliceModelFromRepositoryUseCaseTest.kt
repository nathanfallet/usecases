package me.nathanfallet.usecases.models.list.slice

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListSliceModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvokeLimitOffset() {
        val useCase = ListSliceModelFromRepositoryUseCase(repository)
        every {
            repository.list(1, 0, Unit)
        }.returns(listOf(ModelTest(1, "test")))
        assertEquals(listOf(ModelTest(1, "test")), useCase(1, 0))
    }

}
