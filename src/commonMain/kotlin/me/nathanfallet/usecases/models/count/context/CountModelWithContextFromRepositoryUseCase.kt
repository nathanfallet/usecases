package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class CountModelWithContextFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : CountChildModelWithContextFromRepositoryUseCase<Model, Unit>(repository), ICountModelWithContextUseCase<Model> {

    override fun invoke(input: IContext): Long = invoke(Unit, input)

    override fun invoke(input1: Unit, input2: IContext): Long =
        super<CountChildModelWithContextFromRepositoryUseCase>.invoke(input1, input2)

}
