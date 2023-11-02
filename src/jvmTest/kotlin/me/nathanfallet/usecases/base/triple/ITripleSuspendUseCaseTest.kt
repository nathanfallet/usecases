package me.nathanfallet.usecases.base.triple

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ITripleSuspendUseCaseTest {

    @Test
    fun testInvokeWithTriple() = runBlocking {
        val useCase = object : ITripleSuspendUseCase<Int, Int, Int, String> {
            override suspend fun invoke(input1: Int, input2: Int, input3: Int): String {
                return "$input1 $input2 $input3"
            }
        }
        assertEquals("1 2 3", useCase(Triple(1, 2, 3)))
    }

}