package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class CreateChildModelFromRepositorySuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, CreatePayload, *, ParentId>
) : ICreateChildModelSuspendUseCase<Model, CreatePayload, ParentId> {

    override suspend fun invoke(input1: CreatePayload, input2: ParentId): Model? {
        return repository.create(input1, input2)
    }

}