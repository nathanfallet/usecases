package me.nathanfallet.usecases.models.create.context

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface ICreateChildModelWithContextUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    ITripleUseCase<CreatePayload, ParentId, IContext, Model?>
