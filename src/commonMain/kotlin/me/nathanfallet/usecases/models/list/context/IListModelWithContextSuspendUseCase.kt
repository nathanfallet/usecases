package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface IListModelWithContextSuspendUseCase<Model : IModel<*, *, *>> :
    IListChildModelWithContextSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(input: IContext): List<Model>

    override suspend fun invoke(input1: Unit, input2: IContext): List<Model> = invoke(input2)

}
