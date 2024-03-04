package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface ICountChildModelWithContextUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairUseCase<ParentId, IContext, Long>
