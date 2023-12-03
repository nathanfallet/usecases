package me.nathanfallet.usecases.models.update.context

import me.nathanfallet.usecases.base.IQuadUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IUpdateChildModelWithContextUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    IQuadUseCase<Id, UpdatePayload, ParentId, IContext, Model?>
