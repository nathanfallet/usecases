package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.ISuspendUseCase

interface ICreateModelSuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ISuspendUseCase<CreatePayload, Model?>
