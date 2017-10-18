package com.example.framgianguyenvulan.kotlinbeginning.domain.commands

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastProvider
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.Forecast

/**
 * Created by FRAMGIA\nguyen.vu.lan on 18/10/2017.
 */
class RequestDayForecastCommand(val id: Long,
                                private val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<Forecast> {
    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}