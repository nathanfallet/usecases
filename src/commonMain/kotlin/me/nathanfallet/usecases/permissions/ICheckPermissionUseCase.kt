package me.nathanfallet.usecases.permissions

import me.nathanfallet.usecases.base.IPairUseCase

interface ICheckPermissionUseCase : IPairUseCase<IPermittee, IPermission, Boolean>
