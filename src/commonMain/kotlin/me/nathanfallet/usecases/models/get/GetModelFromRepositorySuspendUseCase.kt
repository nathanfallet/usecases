package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class GetModelFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelSuspendRepository<Model, Id, *, *>
) : GetChildModelFromRepositorySuspendUseCase<Model, Id, Unit>(repository), IGetModelSuspendUseCase<Model, Id> {

    override suspend fun invoke(input: Id): Model? {
        return invoke(input, Unit)
    }

    override suspend fun invoke(input1: Id, input2: Unit): Model? {
        return super<GetChildModelFromRepositorySuspendUseCase>.invoke(input1, input2)
    }

}
