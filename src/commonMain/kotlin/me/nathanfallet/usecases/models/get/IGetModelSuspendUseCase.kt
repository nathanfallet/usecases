package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.models.IModel

interface IGetModelSuspendUseCase<Model : IModel<Id, *, *>, Id> : ISuspendUseCase<Id, Model?>
