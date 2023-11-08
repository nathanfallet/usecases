package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.IModel

data class ModelTest(
    override val id: Long,
    val value: String
) : IModel<Long, CreatePayloadTest, UpdatePayloadTest>
