package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class GetChildModelWithContextFromRepositoryUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, *, ParentId>,
) : IGetChildModelWithContextUseCase<Model, Id, ParentId> {

    override fun invoke(input1: Id, input2: ParentId, input3: IContext): Model? {
        return repository.get(input1, input2, input3)
    }

}
