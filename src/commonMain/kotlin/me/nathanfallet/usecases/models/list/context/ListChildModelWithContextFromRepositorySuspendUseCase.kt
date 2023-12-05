package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class ListChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : IListChildModelWithContextSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input1: ParentId, input2: IContext): List<Model> {
        return repository.list(input1, input2)
    }

}
