package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository

open class ListModelFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>
) : ListChildModelFromRepositoryUseCase<Model, Unit>(repository), IListModelUseCase<Model> {

    override fun invoke(): List<Model> {
        return invoke(Unit)
    }

    override fun invoke(input: Unit): List<Model> {
        return super<ListChildModelFromRepositoryUseCase>.invoke(input)
    }

    override fun invoke(input1: Long, input2: Long): List<Model> {
        return invoke(input1, input2, Unit)
    }

    override fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return super<ListChildModelFromRepositoryUseCase>.invoke(input1, input2, input3)
    }

}
