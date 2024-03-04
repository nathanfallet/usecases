package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class CountChildModelFromRepositoryUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId>(
    private val repository: IChildModelRepository<Model, *, *, *, ParentId>,
) : ICountChildModelUseCase<Model, ParentId> {

    override fun invoke(input: ParentId): Long = repository.count(input)

}
