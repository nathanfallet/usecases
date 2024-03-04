package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

open class CountModelFromRepositorySuspendUseCase<Model : IModel<*, *, *>>(
    repository: IModelSuspendRepository<Model, *, *, *>,
) : CountChildModelFromRepositorySuspendUseCase<Model, Unit>(repository), ICountModelSuspendUseCase<Model> {

    override suspend fun invoke(): Long = invoke(Unit)

    override suspend fun invoke(input: Unit): Long =
        super<CountChildModelFromRepositorySuspendUseCase>.invoke(input)

}
