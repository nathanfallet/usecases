package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class CountChildModelFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : ICountChildModelSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input: ParentId): Long = repository.count(input)

}
