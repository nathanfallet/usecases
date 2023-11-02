package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.ISuspendUseCase

interface IDeleteModelSuspendUseCase<Model : IModel<*, *, *>> : ISuspendUseCase<Model, Boolean>
