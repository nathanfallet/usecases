package me.nathanfallet.usecases.models.list.context

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IListChildModelWithContextUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairUseCase<ParentId, IContext, List<Model>>
