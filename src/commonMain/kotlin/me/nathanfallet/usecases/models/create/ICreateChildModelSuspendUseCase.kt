package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.base.IPairSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel

interface ICreateChildModelSuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    IPairSuspendUseCase<CreatePayload, ParentId, Model?>