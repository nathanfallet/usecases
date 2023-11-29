package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
open class CreateUserChildModelFromRepositoryUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId>(
    private val repository: IChildModelRepository<Model, *, CreatePayload, *, ParentId>
) : ICreateUserChildModelUseCase<Model, CreatePayload, ParentId> {

    override fun invoke(input1: CreatePayload, input2: ParentId, input3: IUser): Model? {
        return repository.create(input1, input2, input3)
    }

}
