package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface IListSliceModelWithContextSuspendUseCase<Model : IModel<*, *, *>> :
    IListSliceChildModelWithContextSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(input1: Long, input2: Long, input3: IContext): List<Model>

    override suspend fun invoke(input1: Long, input2: Long, input3: Unit, input4: IContext): List<Model> {
        return invoke(input1, input2, input4)
    }

}
