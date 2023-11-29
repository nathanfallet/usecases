package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IListSliceChildModelSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ITripleSuspendUseCase<Long, Long, ParentId, List<Model>>

