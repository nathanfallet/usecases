package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.base.IQuadUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
interface IUpdateUserChildModelUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    IQuadUseCase<Id, UpdatePayload, ParentId, IUser, Model?>
