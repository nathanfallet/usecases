package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class CreateModelFromRepositoryUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    private val repository: IModelRepository<Model, *, CreatePayload, *>
) : ICreateModelUseCase<Model, CreatePayload> {

    override fun invoke(input: CreatePayload): Model? {
        return repository.create(input)
    }

}