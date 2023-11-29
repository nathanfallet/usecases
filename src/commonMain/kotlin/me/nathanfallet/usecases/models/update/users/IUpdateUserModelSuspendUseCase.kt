package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser

interface IUpdateUserModelSuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IUpdateUserChildModelSuspendUseCase<Model, Id, UpdatePayload, Unit> {

    suspend operator fun invoke(input1: Id, input2: UpdatePayload, input3: IUser): Model?

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IUser): Model? {
        return invoke(input1, input2, input4)
    }

}
