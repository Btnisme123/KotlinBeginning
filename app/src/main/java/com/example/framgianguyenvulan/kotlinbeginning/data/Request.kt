package com.example.framgianguyenvulan.kotlinbeginning.data

import android.util.Log
import java.net.URL

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */
class Request(val url: String) {

    fun run() {
        val forecastJson = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJson)
    }
}