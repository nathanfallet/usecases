package me.nathanfallet.usecases.singleton

import me.nathanfallet.usecases.base.IUnitUseCase
import me.nathanfallet.usecases.base.IUseCase

interface ISingletonUseCase<T> : IUseCase<T, Unit>, IUnitUseCase<T>
