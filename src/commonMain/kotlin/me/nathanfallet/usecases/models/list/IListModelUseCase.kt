package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel

interface IListModelUseCase<Model : IModel<*, *, *>> : IListChildModelUseCase<Model, Unit> {

    operator fun invoke(): List<Model>
    operator fun invoke(input1: Long, input2: Long): List<Model>

    override fun invoke(input: Unit): List<Model> {
        return invoke()
    }

    override fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return invoke(input1, input2)
    }

}
