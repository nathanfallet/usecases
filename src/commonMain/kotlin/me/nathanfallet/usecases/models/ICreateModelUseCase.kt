package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.IUseCase

interface ICreateModelUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> : IUseCase<CreatePayload, Model?>
