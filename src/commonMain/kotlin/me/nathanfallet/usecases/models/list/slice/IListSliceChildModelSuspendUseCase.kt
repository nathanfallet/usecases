package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.pagination.Pagination

interface IListSliceChildModelSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairSuspendUseCase<Pagination, ParentId, List<Model>>

