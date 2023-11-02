package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class GetModelFromRepositoryUseCase<Model : IModel<Id, *, *>, Id>(
    private val repository: IModelRepository<Model, Id, *, *>
) : IGetModelUseCase<Model, Id> {

    override fun invoke(input: Id): Model? {
        return repository.get(input)
    }

}