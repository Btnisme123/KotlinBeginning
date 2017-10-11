package com.example.framgianguyenvulan.kotlinbeginning.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.framgianguyenvulan.kotlinbeginning.model.ForecastList

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */
class ForecastAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date -$description-$high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}