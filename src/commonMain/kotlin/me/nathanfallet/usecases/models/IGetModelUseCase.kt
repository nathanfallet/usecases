package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.IUseCase

interface IGetModelUseCase<Model : IModel<Id, *, *>, Id> : IUseCase<Id, Model?>
