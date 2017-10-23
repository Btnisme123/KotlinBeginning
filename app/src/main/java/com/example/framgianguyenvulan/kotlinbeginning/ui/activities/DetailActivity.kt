package com.example.framgianguyenvulan.kotlinbeginning.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.example.framgianguyenvulan.kotlinbeginning.R
import com.example.framgianguyenvulan.kotlinbeginning.domain.commands.RequestDayForecastCommand
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.extensions.color
import com.example.framgianguyenvulan.kotlinbeginning.extensions.textColor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.ctx
import org.jetbrains.anko.find
import java.text.DateFormat
import java.util.*

class DetailActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    val ref = asReference()
    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initToolbar()
        toolbarTitle = intent.getStringExtra(CITY_NAME)
        enableHomeAsUp { onBackPressed() }
        title = intent.getStringExtra(CITY_NAME)
        async(UI) {
            val result = bg { RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute() }
            ref().bindForcast(result.await())
        }
    }

    private fun bindForcast(forecast: Forecast) {
        Picasso.with(ctx).load(forecast.iconUrl).into(icon)
        supportActionBar?.subtitle = forecast.date.toDateString(DateFormat.FULL)
        weatherDescription.text = forecast.description
        bindWeather(forecast.high to maxTemperature, forecast.low to minTemperature)
    }

    fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
        val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
        return df.format(this)
    }

    fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }


}
