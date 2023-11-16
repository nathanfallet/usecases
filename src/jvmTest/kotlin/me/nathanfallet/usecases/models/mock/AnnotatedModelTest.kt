package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.annotations.ModelProperty

data class AnnotatedModelTest(
    @ModelProperty("id")
    override val id: Long,
    @ModelProperty("string")
    val value: String,
    @ModelProperty("boolean", "checkbox", true)
    val check: Boolean,
    val ignored: String
) : IModel<Long, AnnotatedCreatePayloadTest, AnnotatedUpdatePayloadTest>
