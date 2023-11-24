package me.nathanfallet.usecases.models.get

import me.nathanfallet.usecases.base.IPairUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IGetChildModelUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId> :
    IPairUseCase<Id, ParentId, Model?>
