package me.nathanfallet.usecases.models.list.slice

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
interface IListSliceChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IPairUseCase<Pagination, ParentId, List<Model>>
