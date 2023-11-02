package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.models.IModel

interface IDeleteModelSuspendUseCase<Model : IModel<Id, *, *>, Id> : ISuspendUseCase<Id, Boolean>
