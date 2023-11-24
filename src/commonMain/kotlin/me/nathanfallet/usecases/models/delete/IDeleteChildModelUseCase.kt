package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IDeleteChildModelUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    IPairUseCase<Id, ParentId, Boolean>
