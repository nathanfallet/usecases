package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelRepository
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
open class UpdateUserModelFromRepositoryUseCase<Model : IModel<Id, *, UpdatePayload>, Id, UpdatePayload>(
    repository: IModelRepository<Model, Id, *, UpdatePayload>
) : UpdateUserChildModelFromRepositoryUseCase<Model, Id, UpdatePayload, Unit>(repository),
    IUpdateUserModelUseCase<Model, Id, UpdatePayload> {

    override fun invoke(input1: Id, input2: UpdatePayload, input3: IUser): Model? {
        return invoke(input1, input2, Unit, input3)
    }

    override fun invoke(input1: Id, input2: UpdatePayload, input3: Unit, input4: IUser): Model? {
        return super<UpdateUserChildModelFromRepositoryUseCase>.invoke(input1, input2, input3, input4)
    }

}
