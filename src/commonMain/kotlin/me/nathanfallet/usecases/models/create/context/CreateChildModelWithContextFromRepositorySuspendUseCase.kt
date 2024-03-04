package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class CreateChildModelWithContextFromRepositorySuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, *, CreatePayload, *, ParentId>,
) : ICreateChildModelWithContextSuspendUseCase<Model, CreatePayload, ParentId> {

    override suspend fun invoke(input1: CreatePayload, input2: ParentId, input3: IContext): Model? =
        repository.create(input1, input2, input3)

}
