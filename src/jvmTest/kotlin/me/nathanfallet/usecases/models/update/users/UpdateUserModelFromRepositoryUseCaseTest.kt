package me.nathanfallet.usecases.models.update.users

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UpdateUserModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = UpdateUserModelFromRepositoryUseCase(repository)
        val user = object : IUser {}
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit, user)
        }.returns(true)
        every {
            repository.get(1, Unit)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), user))
    }

    @Test
    fun testInvokeFails() {
        val useCase = UpdateUserModelFromRepositoryUseCase(repository)
        val user = object : IUser {}
        every {
            repository.update(1, UpdatePayloadTest("test"), Unit, user)
        }.returns(false)
        assertEquals(null, useCase(1, UpdatePayloadTest("test"), user))
    }

}
