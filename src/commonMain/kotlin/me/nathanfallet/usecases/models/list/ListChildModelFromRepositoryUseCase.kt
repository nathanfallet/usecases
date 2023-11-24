package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class ListChildModelFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>
) : IListChildModelUseCase<Model, ParentId> {

    override fun invoke(input: ParentId): List<Model> {
        return repository.list(input)
    }

    override fun invoke(input1: Long, input2: Long, input3: ParentId): List<Model> {
        return repository.list(input1, input2, input3)
    }

}
