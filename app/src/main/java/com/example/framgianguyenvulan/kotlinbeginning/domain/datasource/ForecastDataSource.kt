package com.example.framgianguyenvulan.kotlinbeginning.domain.datasource

import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList

/**
 * Created by FRAMGIA\nguyen.vu.lan on 17/10/2017.
 */
interface ForecastDataSource {
    fun requestForecastByZipcode(zipCode: Long, date: Long): ForecastList?
}