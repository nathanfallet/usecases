package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
open class ListSliceModelWithContextFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : ListSliceChildModelWithContextFromRepositoryUseCase<Model, Unit>(repository),
    IListSliceModelWithContextUseCase<Model> {

    override fun invoke(input1: Pagination, input2: IContext): List<Model> =
        invoke(input1, Unit, input2)

    override fun invoke(input1: Pagination, input2: Unit, input3: IContext): List<Model> =
        super<ListSliceChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2, input3)

}
