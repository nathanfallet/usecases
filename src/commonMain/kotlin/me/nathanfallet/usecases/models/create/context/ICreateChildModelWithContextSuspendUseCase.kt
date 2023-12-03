package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel

interface ICreateChildModelWithContextSuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    ITripleSuspendUseCase<CreatePayload, ParentId, IContext, Model?>
