package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class CreateModelFromRepositorySuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelSuspendRepository<Model, *, CreatePayload, *>
) : CreateChildModelFromRepositorySuspendUseCase<Model, CreatePayload, Unit>(repository),
    ICreateModelSuspendUseCase<Model, CreatePayload> {

    override suspend fun invoke(input: CreatePayload): Model? {
        return invoke(input, Unit)
    }

    override suspend fun invoke(input1: CreatePayload, input2: Unit): Model? {
        return super<CreateChildModelFromRepositorySuspendUseCase>.invoke(input1, input2)
    }

}