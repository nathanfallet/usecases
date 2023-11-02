package me.nathanfallet.usecases.models

data class ModelTest(
    override val id: Long,
    val value: String
) : IModel<Long, CreatePayloadTest, UpdatePayloadTest>
