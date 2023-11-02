package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class GetModelFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    private val repository: IModelSuspendRepository<Model, Id, *, *>
) : IGetModelSuspendUseCase<Model, Id> {

    override suspend fun invoke(input: Id): Model? {
        return repository.get(input)
    }

}