package com.example.framgianguyenvulan.kotlinbeginning.model

/**
 * Created by FRAMGIA\nguyen.vu.lan on 11/10/2017.
 */
import com.example.framgianguyenvulan.kotlinbeginning.data.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.data.ForecastResult
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.framgianguyenvulan.kotlinbeginning.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList
            = ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"
}