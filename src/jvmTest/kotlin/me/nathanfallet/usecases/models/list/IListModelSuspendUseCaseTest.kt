package me.nathanfallet.usecases.models.list

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelSuspendUseCaseTest {

    @Test
    fun testInvoke() = runBlocking {
        val useCase = object : IListModelSuspendUseCase<ModelTest> {
            override suspend fun invoke(): List<ModelTest> = listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit))
    }

}
