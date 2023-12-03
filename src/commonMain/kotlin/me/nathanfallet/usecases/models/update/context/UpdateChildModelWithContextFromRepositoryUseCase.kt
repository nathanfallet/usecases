package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class UpdateChildModelWithContextFromRepositoryUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, UpdatePayload, ParentId>,
) : IUpdateChildModelWithContextUseCase<Model, Id, UpdatePayload, ParentId> {

    override fun invoke(input1: Id, input2: UpdatePayload, input3: ParentId, input4: IContext): Model? {
        return if (repository.update(input1, input2, input3, input4)) repository.get(input1, input3, input4) else null
    }

}
