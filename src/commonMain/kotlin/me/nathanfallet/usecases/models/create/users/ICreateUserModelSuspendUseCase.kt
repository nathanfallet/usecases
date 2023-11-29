package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.users.IUser

interface ICreateUserModelSuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateUserChildModelSuspendUseCase<Model, CreatePayload, Unit> {

    suspend operator fun invoke(input1: CreatePayload, input2: IUser): Model?

    override suspend fun invoke(input1: CreatePayload, input2: Unit, input3: IUser): Model? {
        return invoke(input1, input3)
    }

}
