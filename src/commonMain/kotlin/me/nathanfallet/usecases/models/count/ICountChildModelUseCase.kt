package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport

@JsExport
interface ICountChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> : IUseCase<ParentId, Long>
