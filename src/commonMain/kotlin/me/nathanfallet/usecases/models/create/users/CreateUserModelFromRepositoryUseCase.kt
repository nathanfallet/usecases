package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
open class CreateUserModelFromRepositoryUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelRepository<Model, *, CreatePayload, *>
) : CreateUserChildModelFromRepositoryUseCase<Model, CreatePayload, Unit>(repository),
    ICreateUserModelUseCase<Model, CreatePayload> {

    override fun invoke(input1: CreatePayload, input2: IUser): Model? {
        return invoke(input1, Unit, input2)
    }

    override fun invoke(input1: CreatePayload, input2: Unit, input3: IUser): Model? {
        return super<CreateUserChildModelFromRepositoryUseCase>.invoke(input1, input2, input3)
    }

}
