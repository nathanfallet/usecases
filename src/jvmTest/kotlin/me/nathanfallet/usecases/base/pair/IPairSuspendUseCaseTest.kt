package me.nathanfallet.usecases.base.pair

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class IPairSuspendUseCaseTest {

    @Test
    fun testInvokeWithPair() = runBlocking {
        val useCase = object : IPairSuspendUseCase<String, Int, String> {
            override suspend fun invoke(input1: String, input2: Int): String {
                return "$input1 $input2"
            }
        }
        val result = useCase(Pair("test", 42))
        kotlin.test.assertEquals("test 42", result)
    }

}