package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class DeleteChildModelFromRepositoryUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, *, ParentId>,
) : IDeleteChildModelUseCase<Model, Id, ParentId> {

    override fun invoke(input1: Id, input2: ParentId): Boolean = repository.delete(input1, input2)

}
