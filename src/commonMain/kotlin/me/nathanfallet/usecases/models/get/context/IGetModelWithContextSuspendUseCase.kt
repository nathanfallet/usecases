package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface IGetModelWithContextSuspendUseCase<Model : IModel<Id, *, *>, Id> :
    IGetChildModelWithContextSuspendUseCase<Model, Id, Unit> {

    suspend operator fun invoke(input1: Id, input2: IContext): Model?

    override suspend fun invoke(input1: Id, input2: Unit, input3: IContext): Model? = invoke(input1, input3)

}
