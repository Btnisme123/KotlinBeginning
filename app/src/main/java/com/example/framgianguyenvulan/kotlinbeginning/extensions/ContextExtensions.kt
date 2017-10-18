package com.example.framgianguyenvulan.kotlinbeginning.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/18/17.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)