package me.nathanfallet.usecases.emails

import me.nathanfallet.usecases.base.IPairUseCase

interface ISendEmailUseCase : IPairUseCase<IEmail, List<String>, Unit>
