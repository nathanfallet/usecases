package me.nathanfallet.usecases.models.id

import me.nathanfallet.usecases.models.IChildModel

data class RecursiveId<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    val id: Id,
    val parentId: RecursiveId<*, ParentId, *>? = null,
)
