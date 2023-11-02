package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.IPairUseCase

interface IUpdateModelUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IPairUseCase<Id, UpdatePayload, Model?>
