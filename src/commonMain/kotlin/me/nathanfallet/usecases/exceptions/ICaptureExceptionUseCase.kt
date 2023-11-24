package me.nathanfallet.usecases.exceptions

import me.nathanfallet.usecases.base.IUseCase
import kotlin.js.JsExport

@JsExport
interface ICaptureExceptionUseCase : IUseCase<Throwable, Unit>
