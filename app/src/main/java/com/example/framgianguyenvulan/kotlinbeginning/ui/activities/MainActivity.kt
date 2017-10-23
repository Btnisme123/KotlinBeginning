package com.example.framgianguyenvulan.kotlinbeginning.ui.activities

import android.app.DownloadManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.framgianguyenvulan.kotlinbeginning.R
import com.example.framgianguyenvulan.kotlinbeginning.domain.commands.RequestForecastCommand
import com.example.framgianguyenvulan.kotlinbeginning.extensions.DelegatesExt
import com.example.framgianguyenvulan.kotlinbeginning.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    var zipCode: Long by DelegatesExt.longPreference(this,
            SettingActivity.ZIP_CODE, SettingActivity.DEFAULT_ZIP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast()=doAsync {
        val result=RequestForecastCommand(zipCode).execute()
        uiThread {
            val adapter =ForecastListAdapter(result){
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                        DetailActivity.CITY_NAME to result.city)
            }
            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
    }
    inline fun <T, R> T.let(f: (T) -> R): R = f(this)
}
