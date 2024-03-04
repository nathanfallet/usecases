package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository
import me.nathanfallet.usecases.pagination.Pagination

open class ListSliceModelFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : ListSliceChildModelFromRepositorySuspendUseCase<Model, Unit>(repository), IListSliceModelSuspendUseCase<Model> {

    override suspend fun invoke(input: Pagination): List<Model> = invoke(input, Unit)

    override suspend fun invoke(input1: Pagination, input2: Unit): List<Model> =
        super<ListSliceChildModelFromRepositorySuspendUseCase>.invoke(input1, input2)

}
