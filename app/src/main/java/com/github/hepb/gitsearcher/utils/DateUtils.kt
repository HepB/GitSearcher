package com.github.hepb.gitsearcher.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val ISO_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val VIEW_PATTERN = "dd.MM.yyyy"

fun isoStringToLong(isoDate: String): Long {
    val tz = TimeZone.getTimeZone("UTC")
    val df = SimpleDateFormat(ISO_PATTERN)
    df.timeZone = tz

    try {
        return df.parse(isoDate).time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return 0
}

fun timeToSting(time: Long): String {
    val df = SimpleDateFormat(VIEW_PATTERN)
    return df.format(Date(time))
}