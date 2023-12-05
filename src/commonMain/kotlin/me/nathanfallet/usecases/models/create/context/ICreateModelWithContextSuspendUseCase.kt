package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel

interface ICreateModelWithContextSuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateChildModelWithContextSuspendUseCase<Model, CreatePayload, Unit> {

    suspend operator fun invoke(input1: CreatePayload, input2: IContext): Model?

    override suspend fun invoke(input1: CreatePayload, input2: Unit, input3: IContext): Model? {
        return invoke(input1, input3)
    }

}
