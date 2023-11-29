package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class ListSliceModelFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>
) : ListSliceChildModelFromRepositorySuspendUseCase<Model, Unit>(repository), IListSliceModelSuspendUseCase<Model> {

    override suspend fun invoke(input1: Long, input2: Long): List<Model> {
        return invoke(input1, input2, Unit)
    }

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return super<ListSliceChildModelFromRepositorySuspendUseCase>.invoke(input1, input2, input3)
    }

}
