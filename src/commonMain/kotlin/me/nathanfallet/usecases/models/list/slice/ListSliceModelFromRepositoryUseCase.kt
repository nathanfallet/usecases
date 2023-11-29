package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class ListSliceModelFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>
) : ListSliceChildModelFromRepositoryUseCase<Model, Unit>(repository), IListSliceModelUseCase<Model> {

    override fun invoke(input1: Long, input2: Long): List<Model> {
        return invoke(input1, input2, Unit)
    }

    override fun invoke(input1: Long, input2: Long, input3: Unit): List<Model> {
        return super<ListSliceChildModelFromRepositoryUseCase>.invoke(input1, input2, input3)
    }

}
