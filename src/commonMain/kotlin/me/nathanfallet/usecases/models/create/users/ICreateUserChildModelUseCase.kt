package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser
import kotlin.js.JsExport

@JsExport
interface ICreateUserChildModelUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    ITripleUseCase<CreatePayload, ParentId, IUser, Model?>
