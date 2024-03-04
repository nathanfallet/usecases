package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
open class ListSliceModelFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : ListSliceChildModelFromRepositoryUseCase<Model, Unit>(repository), IListSliceModelUseCase<Model> {

    override fun invoke(input: Pagination): List<Model> = invoke(input, Unit)

    override fun invoke(input1: Pagination, input2: Unit): List<Model> =
        super<ListSliceChildModelFromRepositoryUseCase>.invoke(input1, input2)

}
