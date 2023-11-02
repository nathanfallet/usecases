package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.ISuspendUseCase

interface IGetModelSuspendUseCase<Model : IModel<Id, *, *>, Id> : ISuspendUseCase<Id, Model?>
