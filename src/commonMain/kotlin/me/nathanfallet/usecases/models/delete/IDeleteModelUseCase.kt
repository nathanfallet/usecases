package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel

interface IDeleteModelUseCase<Model : IModel<Id, *, *>, Id> : IDeleteChildModelUseCase<Model, Id, Unit> {

    operator fun invoke(input: Id): Boolean

    override fun invoke(input1: Id, input2: Unit): Boolean {
        return invoke(input1)
    }

}
