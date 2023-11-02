package me.nathanfallet.usecases.exceptions

import me.nathanfallet.usecases.base.ISuspendUseCase

interface ICaptureExceptionSuspendUseCase : ISuspendUseCase<Throwable, Unit>