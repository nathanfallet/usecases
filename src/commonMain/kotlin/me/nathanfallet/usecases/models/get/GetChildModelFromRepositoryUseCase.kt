package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class GetChildModelFromRepositoryUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, *, ParentId>,
) : IGetChildModelUseCase<Model, Id, ParentId> {

    override fun invoke(input1: Id, input2: ParentId): Model? = repository.get(input1, input2)

}
