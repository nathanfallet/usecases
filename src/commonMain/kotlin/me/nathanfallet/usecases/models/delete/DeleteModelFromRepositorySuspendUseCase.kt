package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class DeleteModelFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    private val repository: IModelSuspendRepository<Model, Id, *, *>
) : IDeleteModelSuspendUseCase<Model, Id> {

    override suspend fun invoke(input: Id): Boolean {
        return repository.delete(input)
    }

}