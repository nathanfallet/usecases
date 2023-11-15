package me.nathanfallet.usecases.models.annotations

import me.nathanfallet.usecases.models.mock.AnnotatedCreatePayload
import me.nathanfallet.usecases.models.mock.AnnotatedModelTest
import me.nathanfallet.usecases.models.mock.AnnotatedUpdatePayload
import kotlin.test.Test
import kotlin.test.assertEquals

class ModelAnnotationsTest {

    @Test
    fun testModelKeys() {
        assertEquals(
            listOf(
                ModelKey("id", "id", ""),
                ModelKey("value", "string", ""),
                ModelKey("check", "boolean", "checkbox")
            ),
            ModelAnnotations.modelKeys(AnnotatedModelTest::class)
        )
    }

    @Test
    fun testUpdatePayloadKeys() {
        assertEquals(
            listOf(
                PayloadKey("check", "boolean", "checkbox", false),
                PayloadKey("value", "string", "", true)
            ),
            ModelAnnotations.updatePayloadKeys(
                AnnotatedModelTest::class,
                AnnotatedUpdatePayload::class
            )
        )
    }

    @Test
    fun testCreatePayloadKeys() {
        assertEquals(
            listOf(
                PayloadKey("value", "string", "", true)
            ),
            ModelAnnotations.createPayloadKeys(
                AnnotatedModelTest::class,
                AnnotatedCreatePayload::class
            )
        )
    }

}
