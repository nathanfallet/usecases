package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class ListChildModelFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : IListChildModelUseCase<Model, ParentId> {

    override fun invoke(input: ParentId): List<Model> = repository.list(input)

}
