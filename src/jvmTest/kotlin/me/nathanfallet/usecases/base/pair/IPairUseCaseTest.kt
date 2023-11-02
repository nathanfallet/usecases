package me.nathanfallet.usecases.base.pair

import kotlin.test.Test
import kotlin.test.assertEquals

class IPairUseCaseTest {

    @Test
    fun testInvokeWithPair() {
        val useCase = object : IPairUseCase<String, Int, String> {
            override fun invoke(input1: String, input2: Int): String {
                return "$input1 $input2"
            }
        }
        assertEquals("test 42", useCase(Pair("test", 42)))
    }

}