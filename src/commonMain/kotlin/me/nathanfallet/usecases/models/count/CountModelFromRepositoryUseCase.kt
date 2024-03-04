package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import kotlin.js.JsExport

@JsExport
open class CountModelFromRepositoryUseCase<Model : IModel<*, *, *>>(
    repository: IModelRepository<Model, *, *, *>,
) : CountChildModelFromRepositoryUseCase<Model, Unit>(repository), ICountModelUseCase<Model> {

    override fun invoke(): Long = invoke(Unit)

    override fun invoke(input: Unit): Long = super<CountChildModelFromRepositoryUseCase>.invoke(input)

}
