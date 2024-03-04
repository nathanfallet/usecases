package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class GetModelFromRepositoryUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelRepository<Model, Id, *, *>,
) : GetChildModelFromRepositoryUseCase<Model, Id, Unit>(repository), IGetModelUseCase<Model, Id> {

    override fun invoke(input: Id): Model? = invoke(input, Unit)

    override fun invoke(input1: Id, input2: Unit): Model? =
        super<GetChildModelFromRepositoryUseCase>.invoke(input1, input2)

}
