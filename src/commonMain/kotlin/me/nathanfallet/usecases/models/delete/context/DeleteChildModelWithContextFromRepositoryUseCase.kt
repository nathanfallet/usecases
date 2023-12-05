package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class DeleteChildModelWithContextFromRepositoryUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, *, ParentId>,
) : IDeleteChildModelWithContextUseCase<Model, Id, ParentId> {

    override fun invoke(input1: Id, input2: ParentId, input3: IContext): Boolean {
        return repository.delete(input1, input2, input3)
    }

}
