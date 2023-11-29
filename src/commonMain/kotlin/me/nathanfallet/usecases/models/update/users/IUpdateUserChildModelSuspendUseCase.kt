package me.nathanfallet.usecases.models.update.users

import me.nathanfallet.usecases.base.IQuadSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser

interface IUpdateUserChildModelSuspendUseCase<Model : IChildModel<Id, *, UpdatePayload, ParentId>, Id, UpdatePayload, ParentId> :
    IQuadSuspendUseCase<Id, UpdatePayload, ParentId, IUser, Model?>
