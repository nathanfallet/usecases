package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
open class UpdateUserChildModelFromRepositoryUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, UpdatePayload, ParentId>
) : IUpdateUserChildModelUseCase<Model, Id, UpdatePayload, ParentId> {

    override fun invoke(input1: Id, input2: UpdatePayload, input3: ParentId, input4: IUser): Model? {
        return if (repository.update(input1, input2, input3, input4)) repository.get(input1, input3) else null
    }

}
