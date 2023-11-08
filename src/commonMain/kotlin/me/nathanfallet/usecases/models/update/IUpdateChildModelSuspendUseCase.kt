package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IUpdateChildModelSuspendUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    ITripleSuspendUseCase<Id, UpdatePayload, ParentId, Model?>
