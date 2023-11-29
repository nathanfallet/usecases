package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.users.IUser

open class UpdateUserModelFromRepositorySuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelSuspendRepository<Model, Id, *, UpdatePayload>
) : UpdateUserChildModelFromRepositorySuspendUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateUserModelSuspendUseCase<Model, Id, UpdatePayload> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: IUser): Model? {
        return invoke(input1, input2, Unit, input3)
    }

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IUser): Model? {
        return super<UpdateUserChildModelFromRepositorySuspendUseCase>.invoke(input1, input2, input3, input4)
    }

}
