package me.nathanfallet.usecases.models.count.context

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class CountModelWithContextFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : CountChildModelWithContextFromRepositorySuspendUseCase<Model, Unit>(repository),
    ICountModelWithContextSuspendUseCase<Model> {

    override suspend fun invoke(input: IContext): Long = invoke(Unit, input)

    override suspend fun invoke(input1: Unit, input2: IContext): Long =
        super<CountChildModelWithContextFromRepositorySuspendUseCase>.invoke(input1, input2)

}
