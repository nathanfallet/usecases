package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel

interface IListSliceModelSuspendUseCase<Model : IModel<*, *, *>> : IListSliceChildModelSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(input1: Long, input2: Long): List<Model>

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return invoke(input1, input2)
    }

}
