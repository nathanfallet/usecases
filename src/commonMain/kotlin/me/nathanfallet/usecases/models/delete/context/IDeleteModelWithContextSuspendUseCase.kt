package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface IDeleteModelWithContextSuspendUseCase<Model : IModel<Id, *, *>, Id> :
    IDeleteChildModelWithContextSuspendUseCase<Model, Id, Unit> {

    suspend operator fun invoke(input1: Id, input2: IContext): Boolean

    override suspend fun invoke(input1: Id, input2: Unit, input3: IContext): Boolean {
        return invoke(input1, input3)
    }

}
