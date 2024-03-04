package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class UpdateModelWithContextFromRepositorySuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelSuspendRepository<Model, Id, *, UpdatePayload>,
) : UpdateChildModelWithContextFromRepositorySuspendUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateModelWithContextSuspendUseCase<Model, Id, UpdatePayload> {

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: IContext): Model? =
        invoke(input1, input2, Unit, input3)

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IContext): Model? =
        super<UpdateChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2, input3, input4)

}
