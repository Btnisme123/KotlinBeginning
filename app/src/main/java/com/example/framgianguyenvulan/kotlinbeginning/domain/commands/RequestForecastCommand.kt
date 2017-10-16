package com.example.framgianguyenvulan.kotlinbeginning.domain.commands

import com.example.framgianguyenvulan.kotlinbeginning.data.server.ForecastRequest
import com.example.framgianguyenvulan.kotlinbeginning.domain.mappers.ForecastDataMapper
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}