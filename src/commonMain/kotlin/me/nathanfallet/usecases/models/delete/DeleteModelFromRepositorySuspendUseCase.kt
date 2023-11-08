package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class DeleteModelFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelSuspendRepository<Model, Id, *, *>
) : DeleteChildModelFromRepositorySuspendUseCase<Model, Id, Unit>(repository), IDeleteModelSuspendUseCase<Model, Id> {

    override suspend fun invoke(input: Id): Boolean {
        return invoke(input, Unit)
    }

    override suspend fun invoke(input1: Id, input2: Unit): Boolean {
        return super<DeleteChildModelFromRepositorySuspendUseCase>.invoke(input1, input2)
    }

}