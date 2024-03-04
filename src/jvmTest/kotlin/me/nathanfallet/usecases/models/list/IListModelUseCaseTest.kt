package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.mock.ModelTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IListModelUseCaseTest {

    @Test
    fun testInvoke() {
        val useCase = object : IListModelUseCase<ModelTest> {
            override fun invoke(): List<ModelTest> = listOf(ModelTest(1, "test"))
        }
        assertEquals(listOf(ModelTest(1, "test")), useCase(Unit))
    }

}
