package com.example.framgianguyenvulan.kotlinbeginning.command

import com.example.framgianguyenvulan.kotlinbeginning.data.ForecastRequest
import com.example.framgianguyenvulan.kotlinbeginning.model.ForecastDataMapper
import com.example.framgianguyenvulan.kotlinbeginning.model.ForecastList

/**
 * Created by FRAMGIA\nguyen.vu.lan on 11/10/2017.
 */
class RequestForecastCommand(private val zipcode: String) : Command<ForecastList> {
    override fun excute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}