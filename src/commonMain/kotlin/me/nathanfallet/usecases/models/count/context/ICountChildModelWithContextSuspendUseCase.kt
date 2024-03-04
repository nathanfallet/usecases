package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface ICountChildModelWithContextSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairSuspendUseCase<ParentId, IContext, Long>
