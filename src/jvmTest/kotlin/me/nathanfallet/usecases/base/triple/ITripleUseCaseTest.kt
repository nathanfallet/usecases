package me.nathanfallet.usecases.base.triple

import kotlin.test.Test
import kotlin.test.assertEquals

class ITripleUseCaseTest {

    @Test
    fun testInvokeWithTriple() {
        val useCase = object : ITripleUseCase<Int, Int, Int, String> {
            override fun invoke(input1: Int, input2: Int, input3: Int): String {
                return "$input1 $input2 $input3"
            }
        }
        assertEquals("1 2 3", useCase(Triple(1, 2, 3)))
    }

}