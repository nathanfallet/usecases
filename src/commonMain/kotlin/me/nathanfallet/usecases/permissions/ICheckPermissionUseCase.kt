package me.nathanfallet.usecases.permissions

import me.nathanfallet.usecases.base.IPairUseCase
import kotlin.js.JsExport

@JsExport
interface ICheckPermissionUseCase : IPairUseCase<IPermittee, IPermission, Boolean>
