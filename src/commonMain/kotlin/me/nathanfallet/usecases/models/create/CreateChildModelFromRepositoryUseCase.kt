package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository

open class CreateChildModelFromRepositoryUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId>(
    private val repository: IChildModelRepository<Model, *, CreatePayload, *, ParentId>
) : ICreateChildModelUseCase<Model, CreatePayload, ParentId> {

    override fun invoke(input1: CreatePayload, input2: ParentId): Model? {
        return repository.create(input1, input2)
    }

}