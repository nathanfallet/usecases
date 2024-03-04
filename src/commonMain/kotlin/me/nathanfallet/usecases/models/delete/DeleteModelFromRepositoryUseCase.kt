package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class DeleteModelFromRepositoryUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelRepository<Model, Id, *, *>,
) : DeleteChildModelFromRepositoryUseCase<Model, Id, Unit>(repository), IDeleteModelUseCase<Model, Id> {

    override fun invoke(input: Id): Boolean = invoke(input, Unit)

    override fun invoke(input1: Id, input2: Unit): Boolean =
        super<DeleteChildModelFromRepositoryUseCase>.invoke(input1, input2)

}
