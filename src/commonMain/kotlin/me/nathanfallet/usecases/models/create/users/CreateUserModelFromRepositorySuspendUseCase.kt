package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.users.IUser

open class CreateUserModelFromRepositorySuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelSuspendRepository<Model, *, CreatePayload, *>
) : CreateUserChildModelFromRepositorySuspendUseCase<Model, CreatePayload, Unit>(repository),
    ICreateUserModelSuspendUseCase<Model, CreatePayload> {

    override suspend fun invoke(input1: CreatePayload, input2: IUser): Model? {
        return invoke(input1, Unit, input2)
    }

    override suspend fun invoke(input1: CreatePayload, input2: Unit, input3: IUser): Model? {
        return super<CreateUserChildModelFromRepositorySuspendUseCase>.invoke(input1, input2, input3)
    }

}
