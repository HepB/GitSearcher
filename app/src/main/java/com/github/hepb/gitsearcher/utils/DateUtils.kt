package com.github.hepb.gitsearcher.utils

import android.content.res.Resources
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val ISO_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val VIEW_PATTERN = "dd.MM.yyyy"

fun isoStringToLong(isoDate: String): Long {
    val tz = TimeZone.getTimeZone("UTC")
    val locale = Resources.getSystem().configuration.locale
    val df = SimpleDateFormat(ISO_PATTERN, locale)
    df.timeZone = tz

    try {
        return df.parse(isoDate).time
    } catch (e: ParseException) {
        Timber.e(e.localizedMessage)
    }
    return 0
}

fun timeToSting(time: Long): String {
    val df = SimpleDateFormat(VIEW_PATTERN)
    return df.format(Date(time))
}