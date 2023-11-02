package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class CreateModelFromRepositorySuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    private val repository: IModelSuspendRepository<Model, *, CreatePayload, *>
) : ICreateModelSuspendUseCase<Model, CreatePayload> {

    override suspend fun invoke(input: CreatePayload): Model? {
        return repository.create(input)
    }

}