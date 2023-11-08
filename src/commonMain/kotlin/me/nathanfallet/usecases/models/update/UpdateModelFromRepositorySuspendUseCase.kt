package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class UpdateModelFromRepositorySuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelSuspendRepository<Model, Id, *, UpdatePayload>
) : UpdateChildModelFromRepositorySuspendUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateModelSuspendUseCase<Model, Id, UpdatePayload> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload): Model? {
        return invoke(input1, input2, Unit)
    }

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: Unit): Model? {
        return super<UpdateChildModelFromRepositorySuspendUseCase>.invoke(input1, input2, input3)
    }

}