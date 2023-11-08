package me.nathanfallet.usecases.models.delete

import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.repositories.IChildModelRepository

open class DeleteChildModelFromRepositoryUseCase<Model : IChildModel<Id, *, *, ParentId>, Id, ParentId>(
    private val repository: IChildModelRepository<Model, Id, *, *, ParentId>
) : IDeleteChildModelUseCase<Model, Id, ParentId> {

    override fun invoke(input1: Id, input2: ParentId): Boolean {
        return repository.delete(input1, input2)
    }

}