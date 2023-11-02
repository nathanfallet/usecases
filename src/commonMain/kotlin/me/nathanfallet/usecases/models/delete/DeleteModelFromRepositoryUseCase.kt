package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class DeleteModelFromRepositoryUseCase<Model : IModel<Id, *, *>, Id>(
    private val repository: IModelRepository<Model, Id, *, *>
) : IDeleteModelUseCase<Model, Id> {

    override fun invoke(input: Id): Boolean {
        return repository.delete(input)
    }

}