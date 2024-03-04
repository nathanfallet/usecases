package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class DeleteChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, Id, *, *, ParentId>,
) : IDeleteChildModelWithContextSuspendUseCase<Model, Id, ParentId> {

    override suspend fun invoke(input1: Id, input2: ParentId, input3: IContext): Boolean =
        repository.delete(input1, input2, input3)

}
