package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IModel

interface IDeleteModelUseCase<Model : IModel<Id, *, *>, Id> : IUseCase<Id, Boolean>
