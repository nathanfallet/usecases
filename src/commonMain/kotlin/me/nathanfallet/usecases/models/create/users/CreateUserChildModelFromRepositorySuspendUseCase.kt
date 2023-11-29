package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository
import me.nathanfallet.usecases.users.IUser

open class CreateUserChildModelFromRepositorySuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, CreatePayload, *, ParentId>
) : ICreateUserChildModelSuspendUseCase<Model, CreatePayload, ParentId> {

    override suspend fun invoke(input1: CreatePayload, input2: ParentId, input3: IUser): Model? {
        return repository.create(input1, input2, input3)
    }

}
