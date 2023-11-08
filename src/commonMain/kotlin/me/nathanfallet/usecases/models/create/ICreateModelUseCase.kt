package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel

interface ICreateModelUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload> :
    ICreateChildModelUseCase<Model, CreatePayload, Unit> {

    operator fun invoke(input: CreatePayload): Model?

    override fun invoke(input1: CreatePayload, input2: Unit): Model? {
        return invoke(input1)
    }

}
