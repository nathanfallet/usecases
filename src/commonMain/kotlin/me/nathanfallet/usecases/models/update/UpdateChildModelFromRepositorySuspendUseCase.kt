package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

open class UpdateChildModelFromRepositorySuspendUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId>(
    private val repository: IChildModelSuspendRepository<Model, Id, *, UpdatePayload, ParentId>
) : IUpdateChildModelSuspendUseCase<Model, Id, UpdatePayload, ParentId> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: ParentId): Model? {
        return if (repository.update(input1, input2, input3)) repository.get(input1, input3) else null
    }

}