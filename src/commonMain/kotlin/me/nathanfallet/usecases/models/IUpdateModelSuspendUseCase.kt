package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.IPairSuspendUseCase

interface IUpdateModelSuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IPairSuspendUseCase<Id, UpdatePayload, Model?>
