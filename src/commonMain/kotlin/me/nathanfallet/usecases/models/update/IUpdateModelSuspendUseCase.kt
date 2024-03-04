package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel

interface IUpdateModelSuspendUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload> :
    IUpdateChildModelSuspendUseCase<Model, Id, UpdatePayload, Unit> {

    suspend operator fun invoke(input1: Id, input2: UpdatePayload): Model?

    override suspend fun invoke(input1: Id, input2: UpdatePayload, input3: Unit): Model? = invoke(input1, input2)

}
