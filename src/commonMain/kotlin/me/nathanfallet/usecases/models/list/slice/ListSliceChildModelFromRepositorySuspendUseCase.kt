package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository
import me.nathanfallet.usecases.pagination.Pagination

open class ListSliceChildModelFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : IListSliceChildModelSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input1: Pagination, input2: ParentId): List<Model> = repository.list(input1, input2)

}
