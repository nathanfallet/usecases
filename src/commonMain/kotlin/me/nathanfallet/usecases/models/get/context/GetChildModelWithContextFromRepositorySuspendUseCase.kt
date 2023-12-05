package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class GetChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, Id, *, *, ParentId>,
) : IGetChildModelWithContextSuspendUseCase<Model, Id, ParentId> {

    override suspend fun invoke(input1: Id, input2: ParentId, input3: IContext): Model? {
        return repository.get(input1, input2, input3)
    }

}
