package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.base.pair.IPairUseCase
import me.nathanfallet.usecases.models.IModel

interface IUpdateModelUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IPairUseCase<Id, UpdatePayload, Model?>
