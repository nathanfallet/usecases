package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class UpdateChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, Id, *, UpdatePayload, ParentId>,
) : IUpdateChildModelWithContextSuspendUseCase<Model, Id, UpdatePayload, ParentId> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: ParentId, input4: IContext): Model? =
        if (repository.update(input1, input2, input3, input4)) repository.get(input1, input3, input4)
        else null

}
