package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface ICountModelWithContextSuspendUseCase<Model : IModel<*, *, *>> :
    ICountChildModelWithContextSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(input: IContext): Long

    override suspend fun invoke(input1: Unit, input2: IContext): Long = invoke(input2)

}
