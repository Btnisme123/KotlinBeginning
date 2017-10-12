package com.example.framgianguyenvulan.kotlinbeginning.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgianguyenvulan.kotlinbeginning.R
import com.example.framgianguyenvulan.kotlinbeginning.model.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.model.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */
class ForecastAdapter(val weekForecast: ForecastList,
                      val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.bindForecast(weekForecast[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {


        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}