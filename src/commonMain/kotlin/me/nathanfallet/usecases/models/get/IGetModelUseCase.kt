package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel

interface IGetModelUseCase<Model : IModel<Id, *, *>, Id> : IGetChildModelUseCase<Model, Id, Unit> {

    operator fun invoke(input: Id): Model?

    override fun invoke(input1: Id, input2: Unit): Model? {
        return invoke(input1)
    }

}
