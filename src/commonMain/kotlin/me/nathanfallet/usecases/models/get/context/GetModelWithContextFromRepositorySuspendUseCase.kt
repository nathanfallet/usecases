package me.nathanfallet.usecases.models.get.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class GetModelWithContextFromRepositorySuspendUseCase<Model : IModel<Id, *, *>, Id>(
    repository: IModelSuspendRepository<Model, Id, *, *>,
) : GetChildModelWithContextFromRepositorySuspendUseCase<Model, Id, Unit>(repository),
    IGetModelWithContextSuspendUseCase<Model, Id> {

    override suspend fun invoke(input1: Id, input2: IContext): Model? = invoke(input1, Unit, input2)

    override suspend fun invoke(input1: Id, input2: Unit, input3: IContext): Model? =
        super<GetChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2, input3)

}
