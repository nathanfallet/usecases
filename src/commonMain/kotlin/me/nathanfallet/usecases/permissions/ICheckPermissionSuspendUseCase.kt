package me.nathanfallet.usecases.permissions

import me.nathanfallet.usecases.base.pair.IPairSuspendUseCase

interface ICheckPermissionSuspendUseCase : IPairSuspendUseCase<IPermittee, IPermission, Boolean>
