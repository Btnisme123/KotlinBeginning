package com.example.framgianguyenvulan.kotlinbeginning.data.db

import com.example.framgianguyenvulan.kotlinbeginning.data.server.ForecastServer
import com.example.framgianguyenvulan.kotlinbeginning.domain.datasource.ForecastDataSource
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList
import com.example.framgianguyenvulan.kotlinbeginning.extensions.firstResult

/**
 * Created by FRAMGIA\nguyen.vu.lan on 17/10/2017.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList =
            requestToSource {
                val res = it.requestForecastByZipcode(zipCode, todayTimeSpan())
                if (res != null && res.size >= days) res else null
            }

    private fun requestSource(source: ForecastDataSource, day: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipcode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= day) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
    private fun <T : Any> requestToSource(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }

    fun requestForecast(id: Long): Forecast = requestToSource {
        it.requestDayForecast(id)
    }
}