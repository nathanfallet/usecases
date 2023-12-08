package me.nathanfallet.usecases.models.mock

import kotlinx.datetime.*

data class ConstructPayloadTest(
    val byte: Byte,
    val uByte: UByte,
    val short: Short,
    val uShort: UShort,
    val int: Int,
    val uInt: UInt,
    val long: Long,
    val uLong: ULong,
    val char: Char,
    val float: Float,
    val double: Double,
    val string: String,
    val instant: Instant,
    val localDateTime: LocalDateTime,
    val localDate: LocalDate,
    val localTime: LocalTime,
    val month: Month,
    val dayOfWeek: DayOfWeek,
)
