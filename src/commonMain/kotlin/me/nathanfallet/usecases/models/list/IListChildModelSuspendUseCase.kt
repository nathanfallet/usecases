package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IListChildModelSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ISuspendUseCase<ParentId, List<Model>>
