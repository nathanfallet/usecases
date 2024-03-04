package me.nathanfallet.usecases.models.list.slice.context

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.js.JsExport

@JsExport
interface IListSliceChildModelWithContextUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ITripleUseCase<Pagination, ParentId, IContext, List<Model>>
