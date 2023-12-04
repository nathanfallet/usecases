package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.base.IQuadSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface IListSliceChildModelWithContextSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IQuadSuspendUseCase<Long, Long, ParentId, IContext, List<Model>>
