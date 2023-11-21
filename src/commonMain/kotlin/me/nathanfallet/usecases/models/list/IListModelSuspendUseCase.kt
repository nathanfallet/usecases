package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel

interface IListModelSuspendUseCase<Model : IModel<*, *, *>> : IListChildModelSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(): List<Model>
    suspend operator fun invoke(input1: Long, input2: Long): List<Model>

    override suspend fun invoke(input: Unit): List<Model> {
        return invoke()
    }

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return invoke(input1, input2)
    }

}
