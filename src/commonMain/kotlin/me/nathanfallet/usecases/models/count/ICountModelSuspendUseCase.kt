package me.nathanfallet.usecases.models.count

import me.nathanfallet.usecases.models.IModel

interface ICountModelSuspendUseCase<Model : IModel<*, *, *>> : ICountChildModelSuspendUseCase<Model, Unit> {

    suspend operator fun invoke(): Long

    override suspend fun invoke(input: Unit): Long = invoke()

}
