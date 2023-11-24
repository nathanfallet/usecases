package me.nathanfallet.usecases.localization

import me.nathanfallet.usecases.base.ITripleUseCase

interface ITranslateUseCase : ITripleUseCase<Locale, String, List<String>, String> {

    operator fun invoke(locale: Locale, key: String): String {
        return invoke(locale, key, listOf())
    }

}
