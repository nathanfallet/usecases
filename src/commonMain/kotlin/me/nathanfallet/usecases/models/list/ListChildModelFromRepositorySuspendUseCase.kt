package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class ListChildModelFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>
) : IListChildModelSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input: ParentId): List<Model> {
        return repository.list(input)
    }

    override suspend fun invoke(input1: Long, input2: Long, input3: ParentId): List<Model> {
        return repository.list(input1, input2, input3)
    }

}
