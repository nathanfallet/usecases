package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IModel

interface IGetModelUseCase<Model : IModel<Id, *, *>, Id> : IUseCase<Id, Model?>
