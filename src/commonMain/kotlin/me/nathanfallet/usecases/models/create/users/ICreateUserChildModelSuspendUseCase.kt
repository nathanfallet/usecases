package me.nathanfallet.usecases.models.create.users

import me.nathanfallet.usecases.base.ITripleSuspendUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.users.IUser

interface ICreateUserChildModelSuspendUseCase<Model : IChildModel<*, CreatePayload, *, ParentId>, CreatePayload, ParentId> :
    ITripleSuspendUseCase<CreatePayload, ParentId, IUser, Model?>
