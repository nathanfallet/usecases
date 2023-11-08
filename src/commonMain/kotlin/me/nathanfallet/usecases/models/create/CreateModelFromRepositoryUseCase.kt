package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class CreateModelFromRepositoryUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelRepository<Model, *, CreatePayload, *>
) : CreateChildModelFromRepositoryUseCase<Model, CreatePayload, Unit>(repository),
    ICreateModelUseCase<Model, CreatePayload> {

    override fun invoke(input: CreatePayload): Model? {
        return invoke(input, Unit)
    }

    override fun invoke(input1: CreatePayload, input2: Unit): Model? {
        return super<CreateChildModelFromRepositoryUseCase>.invoke(input1, input2)
    }

}