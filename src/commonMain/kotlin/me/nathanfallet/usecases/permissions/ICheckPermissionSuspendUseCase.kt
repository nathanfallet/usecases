package me.nathanfallet.usecases.permissions

import me.nathanfallet.usecases.base.IPairSuspendUseCase

interface ICheckPermissionSuspendUseCase : IPairSuspendUseCase<IPermittee, IPermission, Boolean>
