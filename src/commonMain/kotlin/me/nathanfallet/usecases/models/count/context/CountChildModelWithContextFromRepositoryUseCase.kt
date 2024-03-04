package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class CountChildModelWithContextFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : ICountChildModelWithContextUseCase<Model, ParentId> {

    override fun invoke(input1: ParentId, input2: IContext): Long = repository.count(input1, input2)

}
