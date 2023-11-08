package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IGetChildModelSuspendUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    IPairSuspendUseCase<Id, ParentId, Model?>