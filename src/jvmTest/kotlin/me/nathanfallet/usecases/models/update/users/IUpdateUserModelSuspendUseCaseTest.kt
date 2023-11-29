package me.nathanfallet.usecases.models.update.users

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.users.IUser
import kotlin.test.Test
import kotlin.test.assertEquals

class IUpdateUserModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IUpdateUserModelSuspendUseCase<ModelTest, Long, UpdatePayloadTest> {
            override suspend fun invoke(input1: Long, input2: UpdatePayloadTest, input3: IUser): ModelTest {
                return ModelTest(1, "test")
            }
        }
        val user = object : IUser {}
        assertEquals(ModelTest(1, "test"), useCase(1, UpdatePayloadTest("test"), Unit, user))
    }

}
