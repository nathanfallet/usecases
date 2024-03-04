package me.nathanfallet.usecases.models.delete.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class DeleteModelWithContextFromRepositoryUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelRepository<Model, Id, *, *>,
) : DeleteChildModelWithContextFromRepositoryUseCase<Model, Id, Unit>(repository),
    IDeleteModelWithContextUseCase<Model, Id> {

    override fun invoke(input1: Id, input2: IContext): Boolean = invoke(input1, Unit, input2)

    override fun invoke(input1: Id, input2: Unit, input3: IContext): Boolean =
        super<DeleteChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2, input3)

}
