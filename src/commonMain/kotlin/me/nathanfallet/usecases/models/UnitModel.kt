package me.nathanfallet.usecases.models

import kotlin.js.JsExport

@JsExport
object UnitModel : IModel<Unit, Unit, Unit> {

    override val id = Unit

}
