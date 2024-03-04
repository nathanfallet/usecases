package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class CountChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, *, *, ParentId>,
) : ICountChildModelWithContextSuspendUseCase<Model, ParentId> {

    override suspend fun invoke(input1: ParentId, input2: IContext): Long = repository.count(input1, input2)

}
