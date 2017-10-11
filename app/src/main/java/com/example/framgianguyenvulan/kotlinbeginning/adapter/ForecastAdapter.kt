package com.example.framgianguyenvulan.kotlinbeginning.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.framgianguyenvulan.kotlinbeginning.R
import com.example.framgianguyenvulan.kotlinbeginning.clicklistener.OnItemClickListener
import com.example.framgianguyenvulan.kotlinbeginning.model.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */
class ForecastAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.size
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val iconView = view.find<ImageView>(R.id.icon)
         val dateView = view.find<TextView>(R.id.date)
         val descriptionView = view.find<TextView>(R.id.description)
         val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
         val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text=date
                descriptionView.text=description
                maxTemperatureView.text="${high}"
                minTemperatureView.text="${low}"
            }
        }
    }

}