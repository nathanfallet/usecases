package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel

interface IListModelSuspendUseCase<Model : IModel<*, *, *>> : IListChildModelSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(): List<Model>

    override suspend fun invoke(input: Unit): List<Model> = invoke()

}
