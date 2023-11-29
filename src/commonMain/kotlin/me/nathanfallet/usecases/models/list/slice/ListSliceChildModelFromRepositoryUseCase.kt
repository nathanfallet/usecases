package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class ListSliceChildModelFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>
) : IListSliceChildModelUseCase<Model, ParentId> {

    override fun invoke(input1: Long, input2: Long, input3: ParentId): List<Model> {
        return repository.list(input1, input2, input3)
    }

}
