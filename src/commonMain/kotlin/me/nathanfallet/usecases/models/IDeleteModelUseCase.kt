package me.nathanfallet.usecases.models

import me.nathanfallet.usecases.base.IUseCase

interface IDeleteModelUseCase<Model : IModel<*, *, *>> : IUseCase<Model, Boolean>
