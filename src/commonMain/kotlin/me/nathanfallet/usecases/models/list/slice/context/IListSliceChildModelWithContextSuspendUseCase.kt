package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.pagination.Pagination

interface IListSliceChildModelWithContextSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ITripleSuspendUseCase<Pagination, ParentId, IContext, List<Model>>
