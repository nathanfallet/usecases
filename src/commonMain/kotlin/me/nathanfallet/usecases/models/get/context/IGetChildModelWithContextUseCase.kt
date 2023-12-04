package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IGetChildModelWithContextUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    ITripleUseCase<Id, ParentId, IContext, Model?>
