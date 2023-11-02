package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IModel

interface ICreateModelUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> : IUseCase<CreatePayload, Model?>
