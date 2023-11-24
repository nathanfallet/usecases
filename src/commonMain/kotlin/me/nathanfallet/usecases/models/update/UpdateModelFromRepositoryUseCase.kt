package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class UpdateModelFromRepositoryUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelRepository<Model, Id, *, UpdatePayload>
) : UpdateChildModelFromRepositoryUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateModelUseCase<Model, Id, UpdatePayload> {

    override fun invoke(input1: Id, input2: UpdatePayload): Model? {
        return invoke(input1, input2, Unit)
    }

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit): Model? {
        return super<UpdateChildModelFromRepositoryUseCase>.invoke(input1, input2, input3)
    }

}
