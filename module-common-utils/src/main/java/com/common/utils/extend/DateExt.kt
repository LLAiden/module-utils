package com.common.utils.extend

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.getDayOfWeekName(style: TextStyle = TextStyle.FULL, locale: Locale = Locale.getDefault()): String {
    return getDayOfWeek().getDisplayName(style, locale)
}