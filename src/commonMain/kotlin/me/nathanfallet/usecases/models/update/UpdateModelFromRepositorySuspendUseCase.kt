package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class UpdateModelFromRepositorySuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    private val repository: IModelSuspendRepository<Model, Id, *, UpdatePayload>
) : IUpdateModelSuspendUseCase<Model, Id, UpdatePayload> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload): Model? {
        return if (repository.update(input1, input2)) repository.get(input1) else null
    }

}