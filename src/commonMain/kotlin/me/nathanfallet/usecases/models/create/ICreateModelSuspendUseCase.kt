package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.models.IModel

interface ICreateModelSuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ISuspendUseCase<CreatePayload, Model?>
