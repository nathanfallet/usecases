package me.nathanfallet.usecases.models.update

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface IUpdateChildModelUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    ITripleUseCase<Id, UpdatePayload, ParentId, Model?>
