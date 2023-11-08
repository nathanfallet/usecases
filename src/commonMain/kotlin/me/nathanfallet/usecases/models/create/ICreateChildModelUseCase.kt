package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.models.IChildModel

interface ICreateChildModelUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    IPairUseCase<CreatePayload, ParentId, Model?>