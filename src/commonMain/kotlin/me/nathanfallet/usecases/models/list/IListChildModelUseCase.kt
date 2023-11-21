package me.nathanfallet.usecases.models.list

import me.nathanfallet.usecases.base.ITripleUseCase
import me.nathanfallet.usecases.base.IUseCase
import me.nathanfallet.usecases.models.IChildModel

interface IListChildModelUseCase<Model : IChildModel<*, *, *, ParentId>, ParentId> :
    IUseCase<ParentId, List<Model>>, ITripleUseCase<Long, Long, ParentId, List<Model>>
