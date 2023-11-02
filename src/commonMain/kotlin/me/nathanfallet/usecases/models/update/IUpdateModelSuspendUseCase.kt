package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.base.pair.IPairSuspendUseCase
import me.nathanfallet.usecases.models.IModel

interface IUpdateModelSuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IPairSuspendUseCase<Id, UpdatePayload, Model?>
