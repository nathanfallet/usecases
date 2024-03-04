package me.nathanfallet.usecases.pagination

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Pagination(
    val limit: Long,
    val offset: Long,
    val options: IPaginationOptions? = null,
)
