package me.nathanfallet.usecases.emails

import me.nathanfallet.usecases.base.IPairSuspendUseCase

interface ISendEmailSuspendUseCase : IPairSuspendUseCase<IEmail, List<String>, Unit>
