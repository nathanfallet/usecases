package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
open class ListSliceChildModelWithContextFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : IListSliceChildModelWithContextUseCase<Model, ParentId> {

    override fun invoke(input1: Pagination, input2: ParentId, input3: IContext): List<Model> =
        repository.list(input1, input2, input3)

}
