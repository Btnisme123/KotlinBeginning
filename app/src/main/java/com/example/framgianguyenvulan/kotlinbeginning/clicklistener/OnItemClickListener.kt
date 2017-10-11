package com.example.framgianguyenvulan.kotlinbeginning.clicklistener

import com.example.framgianguyenvulan.kotlinbeginning.data.Forecast

/**
 * Created by FRAMGIA\nguyen.vu.lan on 11/10/2017.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}