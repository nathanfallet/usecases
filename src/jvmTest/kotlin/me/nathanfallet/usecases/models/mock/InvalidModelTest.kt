package me.nathanfallet.usecases.models.mock

import me.nathanfallet.usecases.models.IModel

data class InvalidModelTest(
    override val id: Unit
) : IModel<Unit, Unit, Unit>
