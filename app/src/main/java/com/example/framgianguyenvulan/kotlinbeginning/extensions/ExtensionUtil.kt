package com.example.framgianguyenvulan.kotlinbeginning.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/23/17.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}