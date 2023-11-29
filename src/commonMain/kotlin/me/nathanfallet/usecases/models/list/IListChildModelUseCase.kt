package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IListChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IUseCase<ParentId, List<Model>>
