package me.nathanfallet.usecases.models.create.users

import io.mockative.*
import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateUserModelFromRepositorySuspendUseCaseTest {

    @Mock
    val repository = mock(classOf<IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest>>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(repository)
    }

    @Test
    fun testInvoke() = runBlocking {
        val useCase = CreateUserModelFromRepositorySuspendUseCase(repository)
        val user = object : IUser {}
        coEvery {
            repository.create(CreatePayloadTest("test"), Unit, user)
        }.returns(ModelTest(1, "test"))
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), user))
    }

}
