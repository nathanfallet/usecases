package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class UpdateModelFromRepositoryUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    private val repository: IModelRepository<Model, Id, *, UpdatePayload>
) : IUpdateModelUseCase<Model, Id, UpdatePayload> {

    override fun invoke(input1: Id, input2: UpdatePayload): Model? {
        return if (repository.update(input1, input2)) repository.get(input1) else null
    }

}