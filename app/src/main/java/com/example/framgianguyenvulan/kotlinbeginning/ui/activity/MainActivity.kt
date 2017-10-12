package com.example.framgianguyenvulan.kotlinbeginning.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.framgianguyenvulan.kotlinbeginning.R
import com.example.framgianguyenvulan.kotlinbeginning.adapter.ForecastAdapter
import com.example.framgianguyenvulan.kotlinbeginning.command.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").excute()
            uiThread {
                forecastList.adapter = ForecastAdapter(result) { forecast ->
                    toast(forecast.date)
                }
            }
        }
    }
}
