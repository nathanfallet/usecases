package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.models.IChildModel
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
interface IListChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    ITripleUseCase<Long, Long, ParentId, List<Model>> {

    @JsName("invokeNoRange")
    operator fun invoke(input: ParentId): List<Model>

}
