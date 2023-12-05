package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface IListChildModelWithContextSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairSuspendUseCase<ParentId, IContext, List<Model>>
