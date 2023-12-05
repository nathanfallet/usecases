package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class ListSliceModelWithContextFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : ListSliceChildModelWithContextFromRepositoryUseCase<Model, Unit>(repository),
    IListSliceModelWithContextUseCase<Model> {

    override fun invoke(input1: Long, input2: Long, input3: IContext): List<Model> {
        return invoke(input1, input2, Unit, input3)
    }

    override fun invoke(input1: Long, input2: Long, input3: Unit, input4: IContext): List<Model> {
        return super<ListSliceChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2, input3, input4)
    }

}
