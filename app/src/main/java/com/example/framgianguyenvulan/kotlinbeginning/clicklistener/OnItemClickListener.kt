package com.example.framgianguyenvulan.kotlinbeginning.clicklistener

import com.example.framgianguyenvulan.kotlinbeginning.model.Forecast


/**
 * Created by FRAMGIA\nguyen.vu.lan on 11/10/2017.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}