package com.example.framgianguyenvulan.kotlinbeginning.domain.commands

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastProvider
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<ForecastList> {
    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}