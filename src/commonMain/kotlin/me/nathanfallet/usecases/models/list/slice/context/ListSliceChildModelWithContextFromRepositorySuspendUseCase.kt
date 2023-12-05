package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class ListSliceChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : IListSliceChildModelWithContextSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input1: Long, input2: Long, input3: ParentId, input4: IContext): List<Model> {
        return repository.list(input1, input2, input3, input4)
    }

}
