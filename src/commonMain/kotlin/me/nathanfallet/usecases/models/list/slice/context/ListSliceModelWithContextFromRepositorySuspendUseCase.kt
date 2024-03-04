package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.pagination.Pagination

open class ListSliceModelWithContextFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : ListSliceChildModelWithContextFromRepositorySuspendUseCase<Model, Unit>(repository),
    IListSliceModelWithContextSuspendUseCase<Model> {

    override suspend fun invoke(input1: Pagination, input2: IContext): List<Model> = invoke(input1, Unit, input2)

    override suspend fun invoke(input1: Pagination, input2: Unit, input3: IContext): List<Model> =
        super<ListSliceChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2, input3)

}
