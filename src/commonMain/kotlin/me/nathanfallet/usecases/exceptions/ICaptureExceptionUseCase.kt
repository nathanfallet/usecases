package me.nathanfallet.usecases.exceptions

import me.nathanfallet.usecases.base.IUseCase

interface ICaptureExceptionUseCase : IUseCase<Throwable, Unit>
