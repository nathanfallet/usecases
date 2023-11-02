package me.nathanfallet.usecases.permissions

class ICheckPermissionUseCaseAsSuspend(private val useCase: ICheckPermissionUseCase) : ICheckPermissionSuspendUseCase {

    override suspend fun invoke(input1: IPermittee, input2: IPermission): Boolean {
        return useCase(input1, input2)
    }

}