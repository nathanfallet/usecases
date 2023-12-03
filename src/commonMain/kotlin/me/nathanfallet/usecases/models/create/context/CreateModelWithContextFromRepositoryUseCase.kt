package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class CreateModelWithContextFromRepositoryUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelRepository<Model, *, CreatePayload, *>,
) : CreateChildModelWithContextFromRepositoryUseCase<Model, CreatePayload, Unit>(repository),
    ICreateModelWithContextUseCase<Model, CreatePayload> {

    override fun invoke(input1: CreatePayload, input2: IContext): Model? {
        return invoke(input1, Unit, input2)
    }

    override fun invoke(input1: CreatePayload, input2: Unit, input3: IContext): Model? {
        return super<CreateChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2, input3)
    }

}
