package me.nathanfallet.usecases.models.create

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class CreateModelFromRepositoryUseCase<Model : IModel<*, CreatePayload, *>, CreatePayload>(
    repository: IModelRepository<Model, *, CreatePayload, *>,
) : CreateChildModelFromRepositoryUseCase<Model, CreatePayload, Unit>(repository),
    ICreateModelUseCase<Model, CreatePayload> {

    override fun invoke(input: CreatePayload): Model? = invoke(input, Unit)

    override fun invoke(input1: CreatePayload, input2: Unit): Model? =
        super<CreateChildModelFromRepositoryUseCase>.invoke(input1, input2)

}
