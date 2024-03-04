package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class ListChildModelWithContextFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : IListChildModelWithContextUseCase<Model, ParentId> {

    override fun invoke(input1: ParentId, input2: IContext): List<Model> = repository.list(input1, input2)

}
