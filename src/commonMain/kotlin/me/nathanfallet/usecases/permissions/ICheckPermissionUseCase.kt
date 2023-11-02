package me.nathanfallet.usecases.permissions

import me.nathanfallet.usecases.base.pair.IPairUseCase

interface ICheckPermissionUseCase : IPairUseCase<IPermittee, IPermission, Boolean>
