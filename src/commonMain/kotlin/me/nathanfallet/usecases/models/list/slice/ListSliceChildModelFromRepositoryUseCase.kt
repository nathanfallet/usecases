package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
open class ListSliceChildModelFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : IListSliceChildModelUseCase<Model, ParentId> {

    override fun invoke(input1: Pagination, input2: ParentId): List<Model> = repository.list(input1, input2)

}
