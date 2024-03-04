package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository
import me.nathanfallet.usecases.pagination.Pagination

open class ListSliceChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : IListSliceChildModelWithContextSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input1: Pagination, input2: ParentId, input3: IContext): List<Model> =
        repository.list(input1, input2, input3)

}
