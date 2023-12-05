package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class ListSliceModelWithContextFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : ListSliceChildModelWithContextFromRepositorySuspendUseCase<Model, Unit>(repository),
    IListSliceModelWithContextSuspendUseCase<Model> {

    override suspend fun invoke(input1: Long, input2: Long, input3: IContext): List<Model> {
        return invoke(input1, input2, Unit, input3)
    }

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit, input4: IContext): List<Model> {
        return super<ListSliceChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2, input3, input4)
    }

}
