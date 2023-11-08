package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel

interface ICreateModelSuspendUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateChildModelSuspendUseCase<Model, CreatePayload, Unit> {

    suspend operator fun invoke(input: CreatePayload): Model?

    override suspend fun invoke(input1: CreatePayload, input2: Unit): Model? {
        return invoke(input1)
    }

}

