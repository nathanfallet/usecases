package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IDeleteChildModelSuspendUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    IPairSuspendUseCase<Id, ParentId, Boolean>
