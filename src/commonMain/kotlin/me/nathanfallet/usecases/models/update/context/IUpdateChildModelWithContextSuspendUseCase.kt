package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.base.IQuadSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface IUpdateChildModelWithContextSuspendUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    IQuadSuspendUseCase<Id, UpdatePayload, ParentId, IContext, Model?>
