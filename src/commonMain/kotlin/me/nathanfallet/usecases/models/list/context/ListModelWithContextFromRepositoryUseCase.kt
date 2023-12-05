package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class ListModelWithContextFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : ListChildModelWithContextFromRepositoryUseCase<Model, Unit>(repository), IListModelWithContextUseCase<Model> {

    override fun invoke(input: IContext): List<Model> {
        return invoke(Unit, input)
    }

    override fun invoke(input1: Unit, input2: IContext): List<Model> {
        return super<ListChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2)
    }

}
