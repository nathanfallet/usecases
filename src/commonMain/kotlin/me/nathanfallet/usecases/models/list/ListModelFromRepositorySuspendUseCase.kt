package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class ListModelFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>
) : ListChildModelFromRepositorySuspendUseCase<Model, Unit>(repository), IListModelSuspendUseCase<Model> {

    override suspend fun invoke(): List<Model> {
        return invoke(Unit)
    }

    override suspend fun invoke(input: Unit): List<Model> {
        return super<ListChildModelFromRepositorySuspendUseCase>.invoke(input)
    }

    override suspend fun invoke(input1: Long, input2: Long): List<Model> {
        return invoke(input1, input2, Unit)
    }

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return super<ListChildModelFromRepositorySuspendUseCase>.invoke(input1, input2, input3)
    }

}
