package me.nathanfallet.usecases.singleton

import me.nathanfallet.usecases.base.ISuspendUseCase
import me.nathanfallet.usecases.base.IUnitSuspendUseCase

interface ISingletonSuspendUseCase<T> : ISuspendUseCase<T, Unit>, IUnitSuspendUseCase<T>
