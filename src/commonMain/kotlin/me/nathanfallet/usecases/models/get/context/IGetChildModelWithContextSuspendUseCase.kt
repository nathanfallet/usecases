package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface IGetChildModelWithContextSuspendUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    ITripleSuspendUseCase<Id, ParentId, IContext, Model?>
