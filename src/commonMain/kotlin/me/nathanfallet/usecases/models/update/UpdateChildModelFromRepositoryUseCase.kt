package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import kotlin.js.JsExport

@JsExport
open class UpdateChildModelFromRepositoryUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, UpdatePayload, ParentId>
) : IUpdateChildModelUseCase<Model, Id, UpdatePayload, ParentId> {

    override fun invoke(input1: Id, input2: UpdatePayload, input3: ParentId): Model? {
        return if (repository.update(input1, input2, input3)) repository.get(input1, input3) else null
    }

}
