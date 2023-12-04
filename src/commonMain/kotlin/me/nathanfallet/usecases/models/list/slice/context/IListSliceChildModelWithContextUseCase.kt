package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.base.IQuadUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IListSliceChildModelWithContextUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IQuadUseCase<Long, Long, ParentId, IContext, List<Model>>
