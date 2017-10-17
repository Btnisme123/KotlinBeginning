package com.example.framgianguyenvulan.kotlinbeginning.data.server

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastDb
import com.example.framgianguyenvulan.kotlinbeginning.domain.datasource.ForecastDataSource
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList

/**
 * Created by FRAMGIA\nguyen.vu.lan on 17/10/2017.
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipcode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipcode(zipCode, date)
    }

}