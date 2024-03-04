package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface ICountChildModelSuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ISuspendUseCase<ParentId, Long>
