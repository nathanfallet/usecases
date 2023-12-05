package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class ListModelWithContextFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : ListChildModelWithContextFromRepositorySuspendUseCase<Model, Unit>(repository),
    IListModelWithContextSuspendUseCase<Model> {

    override suspend fun invoke(input: IContext): List<Model> {
        return invoke(Unit, input)
    }

    override suspend fun invoke(input1: Unit, input2: IContext): List<Model> {
        return super<ListChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2)
    }

}
