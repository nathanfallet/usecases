package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class UpdateModelWithContextFromRepositoryUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelRepository<Model, Id, *, UpdatePayload>,
) : UpdateChildModelWithContextFromRepositoryUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateModelWithContextUseCase<Model, Id, UpdatePayload> {

    override fun invoke(input1: Id, input2: UpdatePayload, input3: IContext): Model? {
        return invoke(input1, input2, Unit, input3)
    }

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IContext): Model? {
        return super<UpdateChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2, input3, input4)
    }

}
