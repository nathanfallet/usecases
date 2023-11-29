package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IListSliceChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ITripleUseCase<Long, Long, ParentId, List<Model>>
