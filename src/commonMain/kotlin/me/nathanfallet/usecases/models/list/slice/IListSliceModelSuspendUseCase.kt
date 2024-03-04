package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.pagination.Pagination

interface IListSliceModelSuspendUseCase<Model : IModel<*, *, *>> : IListSliceChildModelSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(input: Pagination): List<Model>

    override suspend fun invoke(input1: Pagination, input2: Unit): List<Model> = invoke(input1)

}
