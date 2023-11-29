package me.nathanfallet.usecases.models.create.users

import io.mockative.*
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateUserModelFromRepositoryUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() {
        val useCase = CreateUserModelFromRepositoryUseCase(repository)
        val user = object : IUser {}
        every {
            repository.create(CreatePayloadTest("test"), Unit, user)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), user))
    }

}
