package me.nathanfallet.usecases.models.annotations.validators

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PropertyValidatorTest {

    @Test
    fun testValidateStringDefault() {
        assertTrue(PropertyValidator.validate("test", StringPropertyValidator()))
    }

    @Test
    fun testValidateStringRegexMatching() {
        assertTrue(PropertyValidator.validate("abc123", StringPropertyValidator(regex = "[a-z]+[0-9]+")))
    }

    @Test
    fun testValidateStringRegexNotMatching() {
        assertFalse(PropertyValidator.validate("123abc", StringPropertyValidator(regex = "[a-z]+[0-9]+")))
    }

    @Test
    fun testValidateStringMinLengthMatching() {
        assertTrue(PropertyValidator.validate("test", StringPropertyValidator(minLength = 4)))
    }

    @Test
    fun testValidateStringMinLengthNotMatching() {
        assertFalse(PropertyValidator.validate("test", StringPropertyValidator(minLength = 5)))
    }

    @Test
    fun testValidateStringMaxLengthMatching() {
        assertTrue(PropertyValidator.validate("test", StringPropertyValidator(maxLength = 4)))
    }

    @Test
    fun testValidateStringMaxLengthNotMatching() {
        assertFalse(PropertyValidator.validate("test", StringPropertyValidator(maxLength = 3)))
    }

}
