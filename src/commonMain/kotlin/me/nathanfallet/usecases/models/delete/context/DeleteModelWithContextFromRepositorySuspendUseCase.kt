package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class DeleteModelWithContextFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelSuspendRepository<Model, Id, *, *>,
) : DeleteChildModelWithContextFromRepositorySuspendUseCase<Model, Id, Unit>(repository),
    IDeleteModelWithContextSuspendUseCase<Model, Id> {

    override suspend fun invoke(input1: Id, input2: IContext): Boolean {
        return invoke(input1, Unit, input2)
    }

    override suspend fun invoke(input1: Id, input2: Unit, input3: IContext): Boolean {
        return super<DeleteChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2, input3)
    }

}
