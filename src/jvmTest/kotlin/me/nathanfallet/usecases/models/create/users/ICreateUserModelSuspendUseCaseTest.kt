package me.nathanfallet.usecases.models.create.users

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.users.IUser
import kotlin.test.Test
import kotlin.test.assertEquals

class ICreateUserModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : ICreateUserModelSuspendUseCase<ModelTest, CreatePayloadTest> {
            override suspend fun invoke(input1: CreatePayloadTest, input2: IUser): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val user = object : IUser {}
        assertEquals(ModelTest(1, "test"), useCase(CreatePayloadTest("test"), Unit, user))
    }

}
