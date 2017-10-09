package com.example.framgianguyenvulan.kotlinbeginning.model


/**
 * Created by FRAMGIA\nguyen.vu.lan on 09/10/2017.
 */
data class ForecastList(val city:String,val country:String, val dailyForecast:List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)